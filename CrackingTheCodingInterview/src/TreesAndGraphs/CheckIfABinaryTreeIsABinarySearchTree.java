package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

public class CheckIfABinaryTreeIsABinarySearchTree {
    private static Integer prevNumber = null;
    private static boolean isNotBst = false;
    public static void main(String[] args) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        //      3
        //    /  \
        //   2    5
        //       / \
        //     4    6
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value5 = new TreeNode<>(5);
        TreeNode<Integer> value4 = new TreeNode<>(4);
        TreeNode<Integer> value6 = new TreeNode<>(6);
        root.setLeft(value2);
        root.setRight(value5);
        value5.setLeft(value4);
        value5.setRight(value6);

        checkIfBinaryTreeIsBst(tree.getRoot());
        System.out.println("Binary tree is BST: " + !isNotBst);
        System.out.println("Binary tree is BST(with left <= root < right): " +
            checkIfBinaryTreeIsBstWithRestriction(
                tree.getRoot(),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE));


        //      3
        //    /  \
        //   2    5
        //       / \
        //     4    6
        //      \
        //       4

        TreeNode<Integer> value4second = new TreeNode<>(4);
        value4.setRight(value4second);
        isNotBst = false;
        prevNumber = null;
        checkIfBinaryTreeIsBst(tree.getRoot());
        System.out.println("Binary tree is BST: " + !isNotBst);
        System.out.println("Binary tree is BST(with left <= root < right): " +
                checkIfBinaryTreeIsBstWithRestriction(
                        tree.getRoot(),
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE));

        //      3
        //    /  \
        //   2    5
        //       / \
        //     4    6
        //    / \
        //   1   4
        TreeNode<Integer> value1 = new TreeNode<>(1);
        value4.setLeft(value1);
        isNotBst = false;
        prevNumber = null;
        checkIfBinaryTreeIsBst(tree.getRoot());
        System.out.println("Binary tree is BST: " + !isNotBst);
        System.out.println("Binary tree is BST(with left <= root < right): " +
                checkIfBinaryTreeIsBstWithRestriction(
                        tree.getRoot(),
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE));

    }

    public static void checkIfBinaryTreeIsBst(TreeNode<Integer> node){
        if(isNotBst){
            return;
        }

        if(node.getLeft() != null){
            checkIfBinaryTreeIsBst(node.getLeft());
        }

        if(prevNumber != null && prevNumber > node.getValue()){
            isNotBst = true;
        } else {
            prevNumber = node.getValue();
        }

        //System.out.print(node.getValue() + " ");

        if(node.getRight() != null) {
            checkIfBinaryTreeIsBst(node.getRight());
        }
    }

    // If we need to adhere to the rule "left <= root < right", this algorithm allows us to handle cases where
    // the right == root like this:
    //     5
    //      \
    //       5
    public static boolean checkIfBinaryTreeIsBstWithRestriction(TreeNode<Integer> node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.getValue() < min || node.getValue() > max){
            return false;
        }

        return checkIfBinaryTreeIsBstWithRestriction(node.getLeft(), min, node.getValue()) &&
                checkIfBinaryTreeIsBstWithRestriction(node.getRight(), node.getValue() + 1, max);
    }
}
