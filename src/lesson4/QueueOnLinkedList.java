package lesson4;

public class QueueOnLinkedList<T> {
    private LinkedList<T> list;

    public QueueOnLinkedList(){
        list = new LinkedList<>();
    }

    public void insert(T item){
        list.insertLast(item);
    }

    public T delete(){
        return list.delete();
    }

    public void display(){
        list.display();
    }
}
