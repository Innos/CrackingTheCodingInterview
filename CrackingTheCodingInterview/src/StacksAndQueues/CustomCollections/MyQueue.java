package StacksAndQueues.CustomCollections;


import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public MyQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void offer(T element){
        this.stack1.push(element);
    }

    public T peek(){
        if(this.stack2.isEmpty()){
            if(this.stack1.isEmpty()){
                throw new IllegalStateException("Queue is empty");
            }

            shiftStack1ToStack2();
        }

        return this.stack2.peek();
    }

    public T poll(){
        if(this.stack2.isEmpty()){
            if(this.stack1.isEmpty()){
                throw new IllegalStateException("Queue is empty");
            }

            shiftStack1ToStack2();
        }

        return this.stack2.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<T> it = this.stack2.iterator();
        while (it.hasNext()) {
            T e = it.next();
            sb.insert(1, e == this ? "(this Collection)" : e);
            sb.insert(2,',').insert(3,' ');
        }

        it = this.stack1.iterator();
        while(it.hasNext()) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (it.hasNext()){
                sb.append(',').append(' ');
            }
        }

        return sb.append(']').toString();

    }

    private void shiftStack1ToStack2(){
        while(!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
    }
}
