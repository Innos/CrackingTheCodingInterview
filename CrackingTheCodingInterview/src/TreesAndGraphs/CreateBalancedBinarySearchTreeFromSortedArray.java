package TreesAndGraphs;


import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

public class CreateBalancedBinarySearchTreeFromSortedArray {
    public static void main(String[] args) {
        int[] sortedNumbers = new int[]{1,2,3,4,5,6,7};

        //       4
        //      /  \
        //     2    6
        //    / \  / \
        //   1  3 5   7
        BinaryTree<Integer> tree = createBinarySearchTreeFromSortedArray(sortedNumbers);

        int[] sortedNumbers2 = new int[]{1,2,3,4,5,6,7,8};

        //       4
        //      /  \
        //     2    6
        //    / \  / \
        //   1  3 5   7
        //             \
        //              8
        BinaryTree<Integer> tree2 = createBinarySearchTreeFromSortedArray(sortedNumbers2);
        System.out.println();
    }

    public static BinaryTree<Integer> createBinarySearchTreeFromSortedArray(int[] array){
        BinaryTree<Integer> binarySearchTree = new BinaryTree<>();
        binarySearchTree.setRoot(createTree(array,0, array.length - 1));
        return binarySearchTree;
    }

    private static TreeNode<Integer> createTree(int[] array, int start, int end){
        if(end < start){
            return null;
        }

        int mid = (end + start) / 2;
        TreeNode<Integer> node = new TreeNode<>(array[mid]);
        node.setLeft(createTree(array, start, mid - 1));
        node.setRight(createTree(array, mid + 1, end));
        return node;
    }
}
