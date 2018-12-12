package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class CheckIfABinaryTreeIsBalanced {
    private static boolean isUnbalanced = false;
    public static void main(String[] args) {

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


        //      3
        //       \
        //        5
        //       / \
        //     4    6
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.add(3);
        TreeNode<Integer> root2 = tree2.getRoot();
        TreeNode<Integer> secondValue5 = new TreeNode<>(5);
        TreeNode<Integer> secondValue4 = new TreeNode<>(4);
        TreeNode<Integer> secondValue6 = new TreeNode<>(6);
        root2.setRight(secondValue5);
        secondValue5.setLeft(secondValue4);
        secondValue5.setRight(secondValue6);


        System.out.println(isBinaryTreeBalanced(tree));
        System.out.println(isBinaryTreeBalanced(tree2));
    }

    public static boolean isBinaryTreeBalanced(BinaryTree<Integer> tree){
        TreeNode<Integer> root = tree.getRoot();
        if(root == null){
            return true;
        }

        isUnbalanced = false;
        getSubtreeDepth(root,1);

//        int leftDepth = getSubtreeDepth(root.getLeft(), 1);
//        int rightDepth = getSubtreeDepth(root.getRight(), 1);

//        return Math.abs(leftDepth - rightDepth) <= 1;
        return !isUnbalanced;
    }

    private static int getSubtreeDepth(TreeNode<Integer> node, int depth){
        // Short circuit the recursion if we find the tree is unbalanced
        // returned results don't matter anymore as we already know the tree is unbalanced
        if(isUnbalanced){
            return -1;
        }

        if(node == null){
            return depth - 1;
        }

        int leftDepth = getSubtreeDepth(node.getLeft(), depth + 1);
        int rightDepth = getSubtreeDepth(node.getRight(), depth + 1);

        if(Math.abs(leftDepth - rightDepth) > 1){
            isUnbalanced = true;
        }

        return Math.max(leftDepth,rightDepth);
    }
}
