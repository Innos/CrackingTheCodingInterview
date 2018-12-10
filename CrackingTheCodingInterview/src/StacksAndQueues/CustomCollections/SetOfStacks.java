package StacksAndQueues.CustomCollections;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks<T> {
    private ArrayList<Stack<T>> subStacks;
    private int subStackCapacity;

    public SetOfStacks(int subStackCapacity){
        this.subStacks = new ArrayList<>();
        this.subStackCapacity = subStackCapacity;
    }

    public void push(T element){
        int lastStackIndex = this.subStacks.size() - 1;
        if(lastStackIndex == -1 || this.subStacks.get(lastStackIndex).size() == subStackCapacity){
            this.subStacks.add(new Stack<T>());
            lastStackIndex++;
        }

        this.subStacks.get(lastStackIndex).push(element);
    }

    public T pop(){
        int lastStackIndex = tryToGetStackIndexForPop();
        if(lastStackIndex == -1){
            throw new EmptyStackException();
        }

        return this.subStacks.get(lastStackIndex).pop();
    }

    public T popAt(int subStackIndex){
        if(subStackIndex < 0 || subStackIndex >= this.subStacks.size()){
            throw new IllegalArgumentException("The stack index is invalid");
        }

        // the behaviour when attempting to pop a empty stack is not specified
        if(this.subStacks.get(subStackIndex).size() == 0){
            throw new EmptyStackException();
        }

        //rolling over stacks instead of leaving them with less elements is going to make the method horribly slow
        return this.subStacks.get(subStackIndex).pop();
    }

    public T peek(){
        int lastStackIndex = tryToGetStackIndexForPop();
        if(lastStackIndex == -1){
            throw new EmptyStackException();
        }

        return this.subStacks.get(lastStackIndex).peek();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Stack<T> subStack : subStacks) {
            sb.append(subStack.toString());
        }

        return sb.toString();
    }

    private int tryToGetStackIndexForPop(){
        int lastStackIndex = this.subStacks.size() - 1;

        while(lastStackIndex >= 0 && this.subStacks.get(lastStackIndex).size() == 0){
            this.subStacks.remove(lastStackIndex);
            lastStackIndex--;
        }

        return lastStackIndex;
    }
}
