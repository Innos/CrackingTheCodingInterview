package LinkedLists;


import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

import java.util.Stack;

public class CheckIfLinkedListIsPalindrome {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(3);
        list.add(1);

        Node<Integer> middleNode = getMiddleNodeInLinkedList(list);
        boolean isPalindrome = isLinkedListPalindrome(list, middleNode);
        System.out.println(isPalindrome);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.add(7);
        list2.add(5);
        list2.add(4);
        list2.add(7);

        middleNode = getMiddleNodeInLinkedList(list2);
        isPalindrome = isLinkedListPalindrome(list2,middleNode);
        System.out.println(isPalindrome);

        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        list3.add(7);
        list3.add(5);
        list3.add(5);
        list3.add(7);

        middleNode = getMiddleNodeInLinkedList(list3);
        isPalindrome = isLinkedListPalindrome(list3,middleNode);
        System.out.println(isPalindrome);

    }

    /**
     * Finds and returns the middle node in a linked list, if the list has an even number of elements returns the (n/2 + 1)st element
     * @param list The linked list in which to find the middle node
     * @param <T> Generic type
     * @return Returns the middle Node in a linked list
     */
    public static<T> Node<T> getMiddleNodeInLinkedList(SinglyLinkedList<T> list){
        if(list.start == null){
            throw new IllegalArgumentException("Linked list contains no elements");
        }

        Node<T> runner = list.start;
        Node<T> fastRunner = list.start;

        while(fastRunner.getNext() != null){
            runner = runner.getNext();
            fastRunner = fastRunner.getNext();
            if(fastRunner.getNext() != null){
                fastRunner = fastRunner.getNext();
            }
        }

        return runner;
    }

    public static<T> boolean isLinkedListPalindrome(SinglyLinkedList<T> list, Node<T> middleNode){
        if(list.start == null){
            //Is empty list a palindrome?
            return false;
        }

        Stack<T> reverseHalfList = new Stack<>();
        while(middleNode != null){
            reverseHalfList.push(middleNode.getValue());
            middleNode = middleNode.getNext();
        }

        Node<T> current = list.start;
        while(reverseHalfList.size() > 0){
            if(current == null || reverseHalfList.pop() != current.getValue()){
                return  false;
            }

            current = current.getNext();
        }

        return true;
    }
}
