package StacksAndQueues;


import StacksAndQueues.CustomCollections.SetOfStacks;

public class SetOfStacksTest {
    public static void main(String[] args) {
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.push(4);
        stack.push(5);

        System.out.println(stack.toString());
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println(stack.toString());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println(stack.toString());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println(stack.toString());

        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println(stack.toString());
    }
}
