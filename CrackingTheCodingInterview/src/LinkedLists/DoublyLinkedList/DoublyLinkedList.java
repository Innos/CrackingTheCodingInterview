package LinkedLists.DoublyLinkedList;

public class DoublyLinkedList<T> {

    public Node<T> start;
    public Node<T> end;
    private int length;

    public DoublyLinkedList(){
        this.length = 0;
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

            Node<T> newNode = new Node<T>(element,current);
            current.setNext(newNode);
            this.end = newNode;
        }

        this.length++;
    }

    /**
     * Removes the first occurrence of the given element from the list
     * @param element The element to be removed
     */
    public void delete(T element){
        Node<T> current = this.start;
        while(current != null && current.getValue() != element){
            current = current.getNext();
        }

        if(current != null){
            if(this.end == current && this.start == current){
                this.end = null;
                this.start = null;
            }
            else if(this.end == current){
                this.end.getPrevious().setNext(null);
                this.end = this.end.getPrevious();
            }
            else if(this.start == current){
                this.start.getNext().setPrevious(null);
                this.start = this.start.getNext();
            }
            else{
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }

            this.length--;
        }
    }

    public int length(){
        return this.length;
    }
}
