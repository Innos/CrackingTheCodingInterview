package StacksAndQueues;


import StacksAndQueues.CustomCollections.StackWithMin;

import java.util.EmptyStackException;

public class StackWithMinOperation {
    public static void main(String[] args) {
        //peekMin() operation should work in O(1) time
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(6);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(4);

        System.out.println("Stack peek:" + stack.peek());
        System.out.println("Stack min:" + stack.peekMin());
        stack.pop();
        System.out.println("Stack min after 1st pop:" + stack.peekMin());
        stack.pop();
        System.out.println("Stack min after 2nd pop:" + stack.peekMin());
        stack.pop();
        System.out.println("Stack min after 3rd pop:" + stack.peekMin());
        stack.pop();
        System.out.println("Stack min after 4th pop:" + stack.peekMin());
        stack.pop();
        try{
            System.out.println("Stack min after 4th pop:" + stack.peekMin());
        }catch (EmptyStackException ex){
            System.out.println(ex.toString());
        }
    }
}
