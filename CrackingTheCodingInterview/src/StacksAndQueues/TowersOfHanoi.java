package StacksAndQueues;


import java.util.Stack;

public class TowersOfHanoi {

    public static Stack<Integer> start = new Stack<>();
    public static Stack<Integer> support = new Stack<>();
    public static Stack<Integer> end = new Stack<>();

    public static void main(String[] args) {
        start = new Stack<>();
        support = new Stack<>();
        end = new Stack<>();
        //start.push(4);
        start.push(3);
        start.push(2);
        start.push(1);


        printStacks();
        solveHanoi(start, support, end, 3);
        printStacks();
    }

    public static void solveHanoi(Stack<Integer> start, Stack<Integer> support, Stack<Integer> end, int disks){
        if(disks == 0){
            return;
        }
        else if(disks == 1){
            int disk = start.pop();
            end.push(disk);
            return;
        }

        solveHanoi(start, end, support, disks - 1);

        printStacks();

        int disk = start.pop();
        end.push(disk);

        printStacks();

        solveHanoi(support, start, end, disks - 1);
    }

    private static void printStacks(){
        System.out.println("---------------");
        System.out.println("Start: " + start.toString());
        System.out.println("Support: " + support.toString());
        System.out.println("End: " + end.toString());
        System.out.println("---------------");
    }
}
