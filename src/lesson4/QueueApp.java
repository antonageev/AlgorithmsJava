package lesson4;

public class QueueApp {
    public static void main(String[] args) {
        QueueOnLinkedList<Integer> queue = new QueueOnLinkedList<>();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.display();
        System.out.println();
        System.out.println("Элемент " + queue.delete() + " удален из очереди");
        queue.display();
    }
}
