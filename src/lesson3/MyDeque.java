package lesson3;

import java.util.EmptyStackException;

public class MyDeque<T> {
    private T[] deque;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    int start = 0;
    int end = 1;

    public MyDeque(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Bad size");
        deque = (T[]) new Object[capacity];
    }

    public MyDeque(){
        deque = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertEnd (T elem){
        if (isFull()) throw new StackOverflowError();
        size++;
        deque[end] = elem;
        end = nextIndex(end);
    }

    public void insertFront (T elem){
        if (isFull()) throw new StackOverflowError();
        size++;
        deque[start] = elem;
        start = previousIndex(start);
    }

    private int nextIndex(int index){
        return (index + 1) % deque.length;
    }

    private int previousIndex(int index){
        return index == 0 ? deque.length - 1 : index - 1;
    }

    public T peekFront(){
        if (isEmpty()) throw new EmptyStackException();
        return deque[nextIndex(start)];
    }

    public T peekEnd(){
        if (isEmpty()) throw new EmptyStackException();
        return deque[previousIndex(end)];
    }

    public T removeFront(){
        T item  = peekFront();
        deque[nextIndex(start)] = null;
        start = nextIndex(start);
        size--;
        return item;
    }

    public T removeEnd(){
        T item  = peekEnd();
        deque[previousIndex(end)] = null;
        end = previousIndex(end);
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == deque.length;
    }

    public void myToString(){
        for (int i = 0; i < deque.length ; i++) {
            System.out.print(deque[i] + " ");
        }
    }
}
