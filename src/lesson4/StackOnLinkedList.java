package lesson4;

public class StackOnLinkedList<T> {
        private LinkedList<T> list;

        public StackOnLinkedList(){
            list = new LinkedList<>();
        }

        public void push(T i){
            list.insert(i);
        }

        public T pop(){
            return (T) list.delete();
        }

        public boolean isEmpty(){
            return list.isEmpty();
        }

        public void display(){
            list.display();
        }
}
