package lesson3;

import java.util.EmptyStackException;

public class MySortedQueue<T extends Comparable> {
    private T[] queue;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MySortedQueue(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Bad size");
        queue = (T[]) new Comparable[capacity];
    }

    public MySortedQueue(){
        queue = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(T elem) {
        if (isFull()) throw new StackOverflowError();
        queue[size] = elem;
        size++;
        int i = size - 1;
        while (i > 0 && queue[i].compareTo(queue[i - 1]) < 0) {
            swap(i, i - 1);
            i--;
        }
    }

    private void swap(int index1, int index2){
        T temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }

    public T peek(){
        if (isEmpty()) throw new EmptyStackException();
        return queue[size -1 ];
    }

    public T remove(){
        T item  = peek();
        queue[--size] = null;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == queue.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <size ; i++) {
            sb.append(queue[i] + " ");
        }
        return sb.toString();
    }
}
