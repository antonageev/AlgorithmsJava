package lesson4;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(2);
        list.insert(3);
        list.insert(5);

        list.display();
        System.out.println();
        System.out.println(list.delete(3));
        list.display();
        System.out.println();

        System.out.println(list.find(2));
        System.out.println(list.find(6));

        list.insertLast(10);
        list.display();
    }
}
