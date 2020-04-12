package lesson4;

public class NodeIteratorApp {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkIterator<Integer> iter = new LinkIterator<>(list);

        iter.insertBefore(6); //6
        iter.insertAfter(25); // 6, 25
        iter.insertBefore(1); // 6, 1, 25
        iter.insertAfter(40); // 6, 1, 40, 25
        list.display();
        System.out.println();

        iter.reset(); // set on 6
        iter.insertBefore(0); // 0, 6, 1, 40, 25 ;;; set on 0
        list.display();
        System.out.println();

        iter.nextLink(); // set on 6
        iter.nextLink(); // set on 1
        System.out.println(iter.getCurrent()); // 1

        while (!iter.atEnd()){
            iter.nextLink();
        }
        System.out.println(iter.getCurrent()); // 25
        System.out.println(iter.deleteCurrent());
        list.display();

    }
}
