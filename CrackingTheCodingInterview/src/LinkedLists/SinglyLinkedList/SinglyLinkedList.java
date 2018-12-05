package LinkedLists.SinglyLinkedList;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements Iterable<T> {

    public Node<T> start;

    public SinglyLinkedList(){
    }

    public void add(T element){
        if(this.start == null){
            this.start = new Node<T>(element);
        }
        else{
            Node<T> current = this.start;
            while(current.getNext() != null){
                current = current.getNext();
            }

            Node<T> newNode = new Node<T>(element,null);
            current.setNext(newNode);
        }
    }

    /**
     * Removes the first occurrence of the given element from the list
     * @param element The element to be removed
     */
    public void delete(T element){
        if(this.start == null){
            return;
        }

        Node<T> current = this.start;
        if(current.getValue() == element){
            this.start = current.getNext();
            return;
        }

        while(current.getNext() != null && current.getNext().getValue() != element){
            current = current.getNext();
        }

        if(current.getNext() != null){
            current.setNext(current.getNext().getNext());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = start;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.getValue();
                current = current.getNext();
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object o : this) {
            sb.append(o.toString()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
