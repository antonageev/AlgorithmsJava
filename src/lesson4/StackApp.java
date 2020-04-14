package lesson4;

public class StackApp {
    public static void main(String[] args) {
        StackOnLinkedList<Integer> stackOnLinkedList = new StackOnLinkedList<>();
        stackOnLinkedList.push(5);
        stackOnLinkedList.push(10);
        stackOnLinkedList.push(15);
        stackOnLinkedList.display();
        System.out.println();
        System.out.println("Элемент " + stackOnLinkedList.pop() + " удален из стэка");
    }
}
