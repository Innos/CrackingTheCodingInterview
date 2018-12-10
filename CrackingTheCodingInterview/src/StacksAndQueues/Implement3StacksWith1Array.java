package StacksAndQueues;

import StacksAndQueues.CustomCollections.ArrayStack;

import java.util.EmptyStackException;

public class Implement3StacksWith1Array {
    public static Integer[] arrayForStacks = new Integer[10];

    public static void main(String[] args) {
        ArrayStack<Integer> stack1 = new ArrayStack<Integer>(arrayForStacks,0);
        ArrayStack<Integer> stack2 = new ArrayStack<Integer>(arrayForStacks,arrayForStacks.length / 3);
        ArrayStack<Integer> stack3 = new ArrayStack<Integer>(arrayForStacks,(arrayForStacks.length / 3) * 2);

        // Cannot peek on empty stack
        try{
            stack1.peek();
        }catch (EmptyStackException ex){
            System.out.println(ex.toString());
        }

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);

        stack2.push(4);
        stack2.push(3);
        stack2.push(2);

        stack3.push(7);
        stack3.push(13);
        stack3.push(5);

        // Stack capacity full exception
        try{
            stack1.push(40);
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(stack1.peek());
        System.out.println(stack2.peek());
        System.out.println(stack3.peek());

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());


        // Empty stack exception
        try{
            System.out.println(stack1.pop());
        }catch (EmptyStackException ex){
            System.out.println(ex.toString());
        }

    }
}
