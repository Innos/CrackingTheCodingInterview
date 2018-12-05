package LinkedLists;


import LinkedLists.SinglyLinkedList.Node;
import LinkedLists.SinglyLinkedList.SinglyLinkedList;

public class AddNumbersAsLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> firstNumber = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> secondNumber = new SinglyLinkedList<>();

        firstNumber.add(7);
        firstNumber.add(1);
        firstNumber.add(6);

        secondNumber.add(5);
        secondNumber.add(9);
        secondNumber.add(2);

        //expected list 2->1->9 (as 617 + 295 = 912)
        SinglyLinkedList<Integer> resultList = addNumbersAsLinkedListsReversed(firstNumber, secondNumber);
        System.out.println(resultList);

        // expected list 1->3->0->8 (as 716 + 592 = 1308)
        SinglyLinkedList<Integer> resultList2 = addNumbersAsLinkedLists(firstNumber, secondNumber);
        System.out.println(resultList2);
    }

    public static SinglyLinkedList<Integer> addNumbersAsLinkedListsReversed(
            SinglyLinkedList<Integer> firstNumberList,
            SinglyLinkedList<Integer> secondNumberList){

        int firstNumber = 0;
        int secondNumber = 0;

        Node<Integer> current = firstNumberList.start;
        int multiplier = 1;
        while(current != null){
            firstNumber += current.getValue() * multiplier;
            multiplier *= 10;
            current = current.getNext();
        }

        current = secondNumberList.start;
        multiplier = 1;
        while(current != null){
            secondNumber += current.getValue() * multiplier;
            multiplier *= 10;
            current = current.getNext();
        }

        long resultNumber = firstNumber + secondNumber;
        SinglyLinkedList<Integer> resultList = new SinglyLinkedList<>();

        while(resultNumber > 0){
            int lastDigit = (int)(resultNumber % 10);
            resultList.add(lastDigit);
            resultNumber = resultNumber / 10;
        }

        return resultList;
    }

    public static SinglyLinkedList<Integer> addNumbersAsLinkedLists(
            SinglyLinkedList<Integer> firstNumberList,
            SinglyLinkedList<Integer> secondNumberList) {

        StringBuilder firstNumberBuilder = new StringBuilder();
        StringBuilder secondNumberBuilder = new StringBuilder();

        Node<Integer> currentNode = firstNumberList.start;
        while(currentNode != null){
            firstNumberBuilder.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        currentNode = secondNumberList.start;
        while(currentNode != null){
            secondNumberBuilder.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        int firstNumberInOrder = Integer.parseInt(firstNumberBuilder.toString());
        int secondNumberInOrder = Integer.parseInt(secondNumberBuilder.toString());

        long resultNumber = firstNumberInOrder + secondNumberInOrder;
        char[] resultNumberAsCharArray = String.valueOf(resultNumber).toCharArray();

        SinglyLinkedList<Integer> resultList = new SinglyLinkedList<>();

        for (char aResultNumberAsCharArray : resultNumberAsCharArray) {
            resultList.add(Integer.parseInt(String.valueOf(aResultNumberAsCharArray)));
        }

        return resultList;
    }
}
