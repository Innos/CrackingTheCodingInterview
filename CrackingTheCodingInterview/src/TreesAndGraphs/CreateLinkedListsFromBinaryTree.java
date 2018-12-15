package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateLinkedListsFromBinaryTree {
    public static void main(String[] args) {
        //      3
        //    /   \
        //   1     5
        //    \   / \
        //     2 4   7
        //          / \
        //         6  8
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value1 = new TreeNode<>(1);
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value5 = new TreeNode<>(5);
        TreeNode<Integer> value4 = new TreeNode<>(4);
        TreeNode<Integer> value6 = new TreeNode<>(6);
        TreeNode<Integer> value7 = new TreeNode<>(7);
        TreeNode<Integer> value8 = new TreeNode<>(8);
        root.setLeft(value1);
        root.setRight(value5);
        value1.setRight(value2);
        value5.setLeft(value4);
        value5.setRight(value7);
        value7.setLeft(value6);
        value7.setRight(value8);

        List<LinkedList<Integer>> linkedListsBinaryTree = createLinkedLists(tree);
        System.out.println();
    }

    public static<T> List<LinkedList<T>> createLinkedLists(BinaryTree<T> tree){
        List<LinkedList<T>> linkedLists = new ArrayList<>();
        TreeNode<T> root = tree.getRoot();
        addNodesToLinkedLists(root, 0, linkedLists);
        return linkedLists;
    }

    private static<T> void addNodesToLinkedLists(TreeNode<T> node, int depth, List<LinkedList<T>> linkedLists){
        if(node == null){
            return;
        }

        if(linkedLists.size() <= depth){
            linkedLists.add(new LinkedList<T>());
        }

        linkedLists.get(depth).add(node.getValue());

        addNodesToLinkedLists(node.getLeft(), depth + 1, linkedLists);
        addNodesToLinkedLists(node.getRight(), depth+1, linkedLists);
    }
}
