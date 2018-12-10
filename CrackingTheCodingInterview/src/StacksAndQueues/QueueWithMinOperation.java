package StacksAndQueues;


import StacksAndQueues.CustomCollections.PeekMinQueue;
import StacksAndQueues.CustomCollections.QueueWithMin;
import StacksAndQueues.CustomCollections.StackWithMin;

import java.util.EmptyStackException;
import java.util.Queue;

public class QueueWithMinOperation {
    public static void main(String[] args) {
        //peekMin() operation should work in O(1) time
        PeekMinQueue<Integer> queue = new QueueWithMin<>(16);

        System.out.println("Offer '6'");
        queue.offer(6);
        System.out.println("-------------");

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Offer '4'");
        System.out.println("-------------");
        queue.offer(4);

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Offer '5'");
        System.out.println("-------------");
        queue.offer(5);

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Poll queue (Dequeue)");
        queue.poll();
        System.out.println("-------------");

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Offer '5'");
        System.out.println("-------------");
        queue.offer(5);

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Offer '7'");
        System.out.println("-------------");
        queue.offer(7);

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Poll queue (Dequeue)");
        System.out.println("Poll queue (Dequeue)");
        queue.poll();
        queue.poll();
        System.out.println("-------------");

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Offer '3'");
        System.out.println("-------------");
        queue.offer(3);

        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());

        System.out.println("-------------");
        System.out.println("Poll queue (Dequeue)");
        System.out.println("-------------");
        queue.poll();
        System.out.println("Queue elements: " + queue.toString());
        System.out.println("Min Deque elements: " + queue.toStringMinDeque());
        System.out.println("Queue peekMin: " + queue.peekMin());
    }
}
