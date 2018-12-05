package LinkedLists;


import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

public class DeleteNodeFromLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node<Integer> lastNode = list.start.getNext().getNext().getNext().getNext();
        Node<Integer> middleNode = list.start.getNext().getNext();
        Node<Integer> startNode = list.start;

        deleteNodeWithStartAccess(list, lastNode);
        System.out.println(list);
        deleteNodeWithStartAccess(list, middleNode);
        System.out.println(list);
        deleteNodeWithStartAccess(list, startNode);
        System.out.println(list);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Node<Integer> lastNode2 = list2.start.getNext().getNext().getNext().getNext();
        Node<Integer> middleNode2 = list2.start.getNext().getNext();
        Node<Integer> startNode2 = list2.start;

        System.out.println();

        // method does not work with last node
        //deleteNodeWithOnlyNodeAccess(lastNode2);
        //System.out.println(list2);

        deleteNodeWithOnlyNodeAccess(middleNode2);
        System.out.println(list2);
        deleteNodeWithOnlyNodeAccess(startNode2);
        System.out.println(list2);
    }

    public static<T> void deleteNodeWithStartAccess(SinglyLinkedList<T> list, Node<T> nodeToDelete){
        if(list.start == null || nodeToDelete == null){
            return;
        }

        Node<T> current = list.start;
        if(current == nodeToDelete){
            list.start = current.getNext();
        }

        while(current.getNext() != null && current.getNext() != nodeToDelete){
            current = current.getNext();
        }

        if(current.getNext() == nodeToDelete){
            current.setNext(current.getNext().getNext());
        }
    }

    public static<T> void deleteNodeWithOnlyNodeAccess(Node<T> nodeToDelete){
        if(nodeToDelete == null){
            return;
        }

        Node<T> next = nodeToDelete.getNext();
        if(next != null){
            nodeToDelete.setValue(next.getValue());
            nodeToDelete.setNext(next.getNext());
        }
        else{
            throw new IllegalArgumentException("This method cannot be used to delete the last node in a singly linked list");
        }
    }
}
