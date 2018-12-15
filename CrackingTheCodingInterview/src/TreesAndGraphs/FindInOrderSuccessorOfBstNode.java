package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

public class FindInOrderSuccessorOfBstNode {
    public static void main(String[] args) {
        //      3
        //    /  \
        //   2    7
        //       / \
        //     5    8
        //    / \
        //   4   6
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value7 = new TreeNode<>(7);
        TreeNode<Integer> value5 = new TreeNode<>(5);
        TreeNode<Integer> value8 = new TreeNode<>(8);
        TreeNode<Integer> value4 = new TreeNode<>(4);
        TreeNode<Integer> value6 = new TreeNode<>(6);

        root.setLeft(value2);
        root.setRight(value7);
        value7.setLeft(value5);
        value7.setRight(value8);
        value5.setLeft(value4);
        value5.setRight(value6);

        System.out.println("In order successor of root: " + findInOrderSuccessor(tree.getRoot()).getValue());
        System.out.println("In order successor of node 5: " + findInOrderSuccessor(value5).getValue());
    }

    public static TreeNode<Integer> findInOrderSuccessor(TreeNode<Integer> node){
        if(node == null || node.getRight() == null){
            return null;
        }

        node = node.getRight();
        while(node.getLeft() != null){
            node = node.getLeft();
        }

        return node;
    }
}
