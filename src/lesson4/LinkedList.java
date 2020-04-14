package lesson4;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public LinkIterator getIterator(LinkedList<T> list){
        return new LinkIterator(this);
    }


    public LinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(T node){
        Node<T> n = new Node<>(node);
        if (this.isEmpty()){
            this.last = n;
        }
        n.setNext(first);
        this.first = n;
    }

    public void insertLast(T node){
        Node<T> n = new Node<>(node);
        if (this.isEmpty()){
            this.first = n;
        } else {
            last.setNext(n);
        }
        this.last = n;
    }

    public T delete(){
        Node<T> temp = first;
        first = first.getNext();
        return temp.getValue();
    }

    public T delete(T elem){
        Node<T> current = first;
        Node<T> previous = first;
        while(!current.getValue().equals(elem)){
            if(current.getNext() == null)
                return null;
            else{
                previous = current;
                current = current.getNext();
            }
        }
        if(current == first)
            first = first.getNext();
        else
            previous.setNext(current.getNext());
        return current.getValue();
    }


    public void display(){
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    public T find(T searchNode){
        Node<T> findNode = new Node<>(searchNode);
        Node<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}
