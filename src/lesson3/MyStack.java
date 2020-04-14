package lesson3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int size){
        stack = (T[]) new Object[size];
    }

    public MyStack(){
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push (T elem){
        if (isFull()) throw new StackOverflowError();
        stack[size++] = elem;
    }

    public T peek(){
        if (isEmpty()) throw new EmptyStackException();
        return stack[size-1];
    }

    public T pop(){
        T item  = peek();
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == stack.length;
    }
}
