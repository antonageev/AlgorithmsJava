package lesson3;

public class MainApp {
    public static void main(String[] args) {

        //стэк
        MyStack<Integer> myStack = new MyStack<>(7);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);

        for (int i = 0; i < 7; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());

        //очередь
        MyQueue<Integer> queue = new MyQueue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        int temp = queue.size();
        for (int i = 0; i < temp; i++) {
            System.out.println(queue.remove());
        }

        //сортированная очередь
        MySortedQueue<Integer> msq = new MySortedQueue<>(15);
        msq.insert(4);
        msq.insert(10);
        msq.insert(5);
        msq.insert(12);
        msq.insert(41);
        msq.insert(1);

        System.out.println(msq.toString());

        msq.remove();
        System.out.println(msq.toString());

        //читинг с переворотом строки
        StringBuilder stringBuilder = new StringBuilder("reverseString");
        System.out.println(stringBuilder.reverse());

        //свой метод переворота строки
        System.out.println(reverseOrder("OneMoreReverseString"));

        // дека
        MyDeque<Integer> deque = new MyDeque<>();
        deque.insertFront(3);
        deque.insertFront(2);
        deque.insertFront(1);
        deque.insertEnd(4);
        deque.insertEnd(5);

        deque.myToString();
        System.out.println();

        deque.removeFront();
        deque.removeEnd();
        deque.removeEnd();

        deque.myToString();
    }

    public static String reverseOrder(String string){
        StringBuilder sb = new StringBuilder();
        for (int i = string.length()-1; i >=0 ; i--) {
            sb.append(string.charAt(i));
        }
        return sb.toString();
    }

}
