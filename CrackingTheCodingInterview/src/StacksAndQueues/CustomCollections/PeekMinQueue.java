package StacksAndQueues.CustomCollections;

public interface PeekMinQueue<T> {
    boolean offer(T element);
    T poll();
    T peekMin();
    T peek();
    String toString();
    String toStringMinDeque();
}
