package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.BinaryTreeWithParentReference;
import TreesAndGraphs.Collections.TreeNode;
import TreesAndGraphs.Collections.TreeNodeWithParent;

public class FindInOrderSuccessorOfBstNode {
    public static void main(String[] args) {
        //      3
        //    /  \
        //   2    7
        //       / \
        //     5    8
        //    / \
        //   4   6
        BinaryTreeWithParentReference<Integer> tree = new BinaryTreeWithParentReference<>();
        tree.add(3);
        TreeNodeWithParent<Integer> root = tree.getRoot();
        TreeNodeWithParent<Integer> value2 = new TreeNodeWithParent<>(2);
        TreeNodeWithParent<Integer> value7 = new TreeNodeWithParent<>(7);
        TreeNodeWithParent<Integer> value5 = new TreeNodeWithParent<>(5);
        TreeNodeWithParent<Integer> value8 = new TreeNodeWithParent<>(8);
        TreeNodeWithParent<Integer> value4 = new TreeNodeWithParent<>(4);
        TreeNodeWithParent<Integer> value6 = new TreeNodeWithParent<>(6);

        root.setLeft(value2);
        root.setRight(value7);
        value7.setLeft(value5);
        value7.setRight(value8);
        value5.setLeft(value4);
        value5.setRight(value6);

        System.out.println("In order successor of root: " + findInOrderSuccessor(tree.getRoot()).getValue());
        System.out.println("In order successor of node 5: " + findInOrderSuccessor(value5).getValue());

        //Check for case when node has no right subtree
        System.out.println("In order successor of node 2: " + findInOrderSuccessor(value2).getValue());

        //Check for case when node has no right subtree and is not the left child of its parent
        System.out.println("In order successor of node 6: " + findInOrderSuccessor(value6).getValue());

        //Check for case when node has no right subtree and is the largest element in the bst
        TreeNodeWithParent<Integer> inOrderSuccessor = findInOrderSuccessor(value8);
        System.out.println("In order successor of node 8: " + (inOrderSuccessor == null ? "none" : inOrderSuccessor.getValue()));
    }

    public static TreeNodeWithParent<Integer> findInOrderSuccessor(TreeNodeWithParent<Integer> node){
        if(node == null){
            return null;
        }

        // If node has right subtree find left most element in subtree
        if(node.getRight() != null){
            node = node.getRight();
            while(node.getLeft() != null){
                node = node.getLeft();
            }

            return node;
        }

        // If node doesn't have right subtree go up the parents until you find a node which is the left child of its parent
        TreeNodeWithParent<Integer> parent = node.getParent();
        while (parent != null && parent.getRight() == node){
            node = parent;
            parent = parent.getParent();
        }

        return parent;
    }
}
