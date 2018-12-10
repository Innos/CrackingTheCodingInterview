package StacksAndQueues;


import StacksAndQueues.CustomCollections.MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);


        System.out.println("Queue poll: " + myQueue.poll());
        myQueue.offer(4);
        System.out.println("Queue peek: " + myQueue.peek());
        myQueue.offer(5);

        System.out.println(myQueue.toString());

        System.out.println("Queue poll: " + myQueue.poll());
        System.out.println(myQueue.toString());
    }
}
