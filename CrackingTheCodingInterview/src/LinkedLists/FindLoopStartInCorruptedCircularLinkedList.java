package LinkedLists;


import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

import java.util.HashSet;

public class FindLoopStartInCorruptedCircularLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');

        Node<Character> nodeB = list.start.getNext();
        Node<Character> nodeC = list.start.getNext().getNext();
        Node<Character> nodeE = nodeC.getNext().getNext();

        nodeE.setNext(nodeC);
        Node<Character> loopStartingNode = getLoopStartNodeUsingBuffer(list);
        System.out.println(loopStartingNode.getValue());

        nodeE.setNext(nodeB);
        loopStartingNode = getLoopStartNodeUsingBuffer(list);
        System.out.println(loopStartingNode.getValue());

        nodeE.setNext(nodeE);
        loopStartingNode = getLoopStartNodeUsingBuffer(list);
        System.out.println(loopStartingNode.getValue());

        System.out.println();

        nodeE.setNext(nodeC);
        loopStartingNode = getLoopStartNodeWithoutBuffer(list);
        System.out.println(loopStartingNode.getValue());

        nodeE.setNext(nodeB);
        loopStartingNode = getLoopStartNodeWithoutBuffer(list);
        System.out.println(loopStartingNode.getValue());

        nodeE.setNext(nodeE);
        loopStartingNode = getLoopStartNodeWithoutBuffer(list);
        System.out.println(loopStartingNode.getValue());
    }

    // Solution is same as Remove duplicates from unsorted list, but for nodes instead of values
    public static<T> Node<T> getLoopStartNodeUsingBuffer(SinglyLinkedList<T> list){
        if(list.start == null){
            throw new IllegalArgumentException("Linked list is empty");
        }

        Node<T> current = list.start;
        HashSet<Node<T>> foundReferences = new HashSet<>();
        while(current != null){
            if(foundReferences.contains(current)){
                return current;
            }

            foundReferences.add(current);
            current = current.getNext();
        }

        throw new IllegalArgumentException("The Linked list contains no cycles");
    }

    public static<T> Node<T> getLoopStartNodeWithoutBuffer(SinglyLinkedList<T> list){
        if(list.start == null){
            throw new IllegalArgumentException("Linked list is empty");
        }

        Node<T> current = list.start;
        Node<T> fast = list.start;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            current = current.getNext();

            if(current == fast){
                break;
            }
        }

        if(fast == null){
            throw new IllegalArgumentException("The linked list has no loop");
        }

        current = list.start;
        int stepsFromStart = 0;
        while(current != fast){
            current = current.getNext();
            fast = fast.getNext();
            stepsFromStart++;
        }

        //System.out.println(stepsFromStart);
        return current;
    }
}
