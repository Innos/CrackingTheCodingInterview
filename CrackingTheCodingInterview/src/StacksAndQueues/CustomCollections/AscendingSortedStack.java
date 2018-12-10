package StacksAndQueues.CustomCollections;


import java.util.EmptyStackException;
import java.util.Stack;

public class AscendingSortedStack<T extends Comparable<T>> {
    private Stack<T> items;
    private Stack<T> auxiliary;

    public AscendingSortedStack(){
        this.items = new Stack<>();
        this.auxiliary = new Stack<>();
    }

    // this implementation has most of the work on the push method, but offers O(1) peek and pop methods
    public void push(T item){
        if(isEmpty()){
            this.items.push(item);
        }else {
            while(item.compareTo(this.items.peek()) < 0){
                this.auxiliary.push(this.items.pop());
            }

            this.items.push(item);

            // If it's expected to have very few pop and peek calls and a lot of push calls, the push method can be made to check the top of the items stack
            // and then decide if it should continue checking in the items or auxiliary stack, shifting any elements that need to be passed
            // to the other stack in the process. When a pop/peek is called the auxiliary stack should be shifted to the items stack
            while(!this.auxiliary.isEmpty()){
                this.items.push(this.auxiliary.pop());
            }
        }
    }

    public T pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return this.items.pop();
    }

    public T peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return this.items.peek();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }
}
