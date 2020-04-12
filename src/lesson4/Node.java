package lesson4;

public class Node<T> {
    private T node;
    private Node<T> next;

    public Node(T node){
        this.node = node;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue(){
        return node;
    }
}
