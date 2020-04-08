package lesson3;

import java.util.EmptyStackException;

public class MyQueue<T> {
    private T[] queue;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    int start = 0;
    int end = 0;

    public MyQueue(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Bad size");
        queue = (T[]) new Object[capacity];
    }

    public MyQueue(){
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert (T elem){
        if (isFull()) throw new StackOverflowError();
        size++;
        queue[end] = elem;
        end = nextIndex(end);
    }

    private int nextIndex(int index){
        return (index + 1) % queue.length;
    }

    public T peekFront(){
        if (isEmpty()) throw new EmptyStackException();
        return queue[start];
    }

    public T remove(){
        T item  = peekFront();
        queue[start] = null;
        start = nextIndex(start);
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == queue.length;
    }

    public int size(){
        return size;
    }

    public void myToString(){
        for (int i = 0; i <queue.length ; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}
