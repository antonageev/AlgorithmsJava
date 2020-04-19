package lesson6;

public class MyTreeMap<Key extends Comparable<Key>, Value> {

    Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        int size;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public String printRootValues(){
        return "root key :" + root.key + " Root value: " + root.value;
    }

    private int size(Node node){
        if (node == null) return 0;
        return node.size;
    }

    public int size(){
        return size(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    private boolean isKeyNotNull (Key key){
        if (key == null) throw new IllegalArgumentException("Ключ не может быть null");
        return true;
    }

    //поиск Node по ключу
    private Value get (Node node, Key key){
        isKeyNotNull(key);

        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public Value get(Key key){
        return get(root, key);
    }

    public boolean contains (Key key){
        return get(key) != null; // можно же и публичным методом искать...
    }

    private Node put(Node node, Key key, Value value){
        if (node == null) return new Node(key, value);

        int cmp = key.compareTo(node.key);
        if (cmp > 0){
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        // пересчет размера узла
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void put(Key key, Value value){
        isKeyNotNull(key);
        if (value == null){
           // delete(key);
        }
        root = put(root, key, value);
    }

    @Override
    public String toString(){
        return toString(root);
    }

    private String toString(Node node){
        if (node == null) return "";

        return toString(node.left) + " " + node.key.toString() + " = " + node.value.toString() + " " +  toString(node.right);
    }

    public Key minKey(){
        return min(root).key;
    }

    private Node min(Node node){
        if (node.left == null) return node;
        return min(node.left);
    }

    public Key maxKey(){
        return max(root).key;
    }

    private Node max(Node node){
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node deleteMin (Node node){
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete (Key key){
        isKeyNotNull(key);
        delete(root, key);
    }

    private Node delete(Node node, Key key){
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            if (node == root){
                Node temp = root;
                root = min(root.right);

                root.right = deleteMin(temp.right);
                root.left = temp.left;
                node = root;
            } else {
                Node temp = node;
                node = min(node.right);

                node.right = deleteMin(temp.right);
                node.left = temp.left;
                // вникал в код с вебинара и обнаружил, что удаление элемента работает только если
                // удаляемый элемент не root. В случае попытки удаления root, алгоритм удаления работает не правильно
                // и задваивает правую ветвь (попробуйте на своем коде удалить корневой элемент).
                // для чистоты эксперимента с правой ветке должен быть только один элемент (у меня корневой был 5,
                // а в правой ветке была один Node с ключом 8.
                // я дебажил половину выходных, но так и не понял, ПОЧЕМУ это происходит. В итоге сделал дополнительное
                // условие на попытку удаления root и работал с ним отдельно.

            }
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int countLevels(){
        return countLevels(root, 0);
    }

    private int countLevels(Node node, int counter){
        if (node == null) return counter;
        return Math.max(countLevels(node.left, counter + 1), countLevels(node.right, counter + 1));


    }

}
