package StacksAndQueues.CustomCollections;


import java.util.Arrays;
import java.util.EmptyStackException;

public class StandardStack<T> {
    private Object[] array;
    private int capacity;
    private int index;

    public StandardStack(){
        this.capacity = 16;
        this.array = new Object[this.capacity];
        this.index = -1;
    }

    public void push(T element){
        if(this.index + 1 == this.array.length){
            this.resize();
        }

        this.index++;
        this.array[this.index] = element;
    }

    public T pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return element(this.index--);
    }

    public T peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return element(this.index);
    }

    @SuppressWarnings("unchecked")
    private T element(int index) {
        return (T)array[index];
    }

    private boolean isEmpty(){
        return this.index < 0;
    }

    private void resize(){
        this.capacity = this.capacity * 2;
        this.array = Arrays.copyOf(this.array, this.capacity);
    }
}
