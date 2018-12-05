package LinkedLists;

import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

public class PartitionLinkedListByPivot {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(7);
        list.add(54);
        list.add(13);
        list.add(2);
        list.add(28);

        int pivot = 20;

        System.out.println(list);
        sortLinkedListAroundPivot(list, pivot);
        System.out.println(list);

    }

    public static<T extends Comparable<T>> void sortLinkedListAroundPivot(SinglyLinkedList<T>list, T pivot){
        if(list.start == null){
            return;
        }

        Node<T> current = list.start;
        while(current != null){
            Node<T> next = current.getNext();
            if(next != null && next.getValue().compareTo(pivot) < 0){
                current.setNext(next.getNext());
                next.setNext(list.start);
                list.start = next;
            }
            else{
                current = current.getNext();
            }
        }
    }
}
