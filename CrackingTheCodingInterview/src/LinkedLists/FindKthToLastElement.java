package LinkedLists;

import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

public class FindKthToLastElement {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> items = new SinglyLinkedList<>();
        items.add(1);
        items.add(6);
        items.add(13);
        items.add(7);
        items.add(4);

        Node<Integer> result = findKthToLast(items,6);
        System.out.println(result == null ? "No such element" : result.getValue());

    }

    public static <T> Node<T> findKthToLast(SinglyLinkedList<T> list, int offset){
        if(list.start == null){
            return null;
        }

        int runnerElements = 1;
        Node<T> runner = list.start;
        Node<T> kthElement = list.start;

        while(runner.getNext() != null){
            runner = runner.getNext();
            runnerElements++;

            if(runnerElements > offset){
                kthElement = kthElement.getNext();
            }
        }

        if(runnerElements >= offset){
            return kthElement;
        }
        else{
            return null;
        }
    }
}
