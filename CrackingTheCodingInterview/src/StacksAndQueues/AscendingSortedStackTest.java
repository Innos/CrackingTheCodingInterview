package StacksAndQueues;


import StacksAndQueues.CustomCollections.AscendingSortedStack;

public class AscendingSortedStackTest {
    public static void main(String[] args) {
        AscendingSortedStack<Integer> sortedStack = new AscendingSortedStack<>();
        sortedStack.push(3);
        sortedStack.push(19);
        sortedStack.push(7);

        System.out.println("Peek: " + sortedStack.peek());
        System.out.println("Pop: " + sortedStack.pop());
        System.out.println("Push '4'");
        sortedStack.push(4);

        System.out.println("Peek: " + sortedStack.peek());
        System.out.println("Pop: " + sortedStack.pop());
        System.out.println("Pop: " + sortedStack.pop());
        System.out.println("Pop: " + sortedStack.pop());
    }
}
