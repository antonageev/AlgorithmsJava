package lesson4;

public class LinkIterator<T> {
    private Node<T> current;
    private Node<T> previous;
    private LinkedList<T> list;

    public LinkIterator(LinkedList<T> list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.getNext() == null);
    }

    public void nextLink(){
        previous = current;
        current = current.getNext();
    }

    public T getCurrent(){
        return current.getValue();
    }

    public void insertAfter(T node){
        Node<T> newNode = new Node(node);
        if (list.isEmpty()){
            list.setFirst(newNode);
            current = newNode;
        } else {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            nextLink();
        }
    }

    public void insertBefore(T node){
        Node<T> newNode = new Node(node);
        if(previous == null){
            newNode.setNext(list.getFirst());
            list.setFirst(newNode);
            reset();
        }
        else{
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            current = newNode;
        }
    }

    public T deleteCurrent(){
        T field = current.getValue();
        if (previous == null){
            list.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()){
                reset();
            } else {
                current = current.getNext();
            }
        }

        return field;
    }

}
