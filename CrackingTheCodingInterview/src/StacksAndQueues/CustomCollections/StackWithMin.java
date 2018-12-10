package StacksAndQueues.CustomCollections;

import java.util.Stack;

public class StackWithMin<T extends Comparable<T>> extends Stack<T> {
    private Stack<T> min;

    public StackWithMin(){
        super();
        this.min = new Stack<T>();
    }

    public T peekMin(){
        return this.min.peek();
    }


    @Override
    public T push(T item) {
        if(this.min.empty() || item.compareTo(this.min.peek()) <= 0){
            this.min.push(item);
        }

        return super.push(item);
    }

    @Override
    public synchronized T pop() {
        if(!this.isEmpty() && this.peek().compareTo(this.min.peek()) == 0){
            this.min.pop();
        }

        return super.pop();
    }
}
