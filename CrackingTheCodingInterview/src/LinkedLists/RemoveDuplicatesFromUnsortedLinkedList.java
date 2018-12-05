package LinkedLists;


import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> unsortedLinkedList = new SinglyLinkedList<>();
        unsortedLinkedList.add(7);
        unsortedLinkedList.add(1);
        unsortedLinkedList.add(67);
        unsortedLinkedList.add(13);
        unsortedLinkedList.add(66);
        unsortedLinkedList.add(7);
        unsortedLinkedList.add(13);
        unsortedLinkedList.add(67);

        //removeDuplicatesWithoutBuffer(unsortedLinkedList);
        removeDuplicatesWithBuffer(unsortedLinkedList);

        System.out.println("Duplicates removed");
        System.out.println(unsortedLinkedList);
    }

    public static <T> void removeDuplicatesWithBuffer(SinglyLinkedList<T> list){
        Node<T> current = list.start;
        if(current == null){
            return;
        }

        HashSet<T> uniqueElements = new HashSet<>();
        Node<T> prev = null;
        while(current.getNext() != null){
            if(uniqueElements.contains(current.getValue())){
                prev.setNext(current.getNext());
            }
            else {
                uniqueElements.add(current.getValue());
                prev = current;
            }

            current = current.getNext();
        }
    }

    public static <T> void removeDuplicatesWithoutBuffer(SinglyLinkedList<T> list){
        Node<T> current = list.start;
        if(current == null){
            return;
        }

        while(current.getNext() != null){
            Node<T> runner = current;
            while(runner.getNext() != null){
                if(runner.getNext().getValue() == current.getValue()){
                    runner.setNext(runner.getNext().getNext());
                }
                else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }
}
