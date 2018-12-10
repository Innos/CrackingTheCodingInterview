package StacksAndQueues.CustomCollections;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueWithMin<T extends Comparable<T>> extends ArrayBlockingQueue<T> implements PeekMinQueue<T> {
    private Deque<T> min;

    public QueueWithMin(int capacity) {
        super(capacity);
        this.min = new ArrayDeque<>();
    }

    @Override
    public T peekMin() {
        return this.min.peek();
    }

    @Override
    public String toStringMinDeque() {
        return this.min.toString();
    }

    @Override
    public boolean offer(T element) {
        if(this.isEmpty() || element.compareTo(this.min.peekLast()) >= 0){
            this.min.offer(element);
        }
        else{
            while(this.min.size() > 0 && element.compareTo(this.min.peekLast()) < 0){
                this.min.pollLast();
            }

            this.min.offerLast(element);
        }

        return super.offer(element);
    }

    @Override
    public T poll() {
        if(!this.isEmpty() && this.peek().compareTo(this.min.peek()) == 0){
            this.min.poll();
        }

        return super.poll();
    }
}
