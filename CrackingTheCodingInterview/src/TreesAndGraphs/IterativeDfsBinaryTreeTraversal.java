package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Innos on 12/16/2018.
 */
public class IterativeDfsBinaryTreeTraversal {
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

        Stack<TreeNode<Integer>> stack = new Stack<>();
        List<TreeNode<Integer>> result = new ArrayList<>();
        stack.push(tree.getRoot());

        // Good rule to remember code for iterative DFS is the same as for BFS we only change queue to stack
        while(!stack.isEmpty()){
            TreeNode<Integer> current = stack.pop();
            result.add(current);

            if(current.getLeft() != null){
                stack.push(current.getLeft());
            }

            if(current.getRight() != null){
                stack.push(current.getRight());
            }
        }

        // if we want to print starting from the leaves
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i).getValue() + " ");
        }

    }
}
