package TreesAndGraphs;


import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

//      3
//    /   \
//   2     5
//  /     / \
// 1    4    6


public class BinaryTreeTraversal {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value1 = new TreeNode<>(1);
        TreeNode<Integer> value5 = new TreeNode<>(5);
        TreeNode<Integer> value4 = new TreeNode<>(4);
        TreeNode<Integer> value6 = new TreeNode<>(6);
        root.setLeft(value2);
        value2.setLeft(value1);
        root.setRight(value5);
        value5.setLeft(value4);
        value5.setRight(value6);

        System.out.print("In Order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("Pre Order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("Post Order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }

    public static void inOrderTraversal(TreeNode<Integer> node){
        if(node.getLeft() != null){
            inOrderTraversal(node.getLeft());
        }

        System.out.print(node.getValue() + " ");

        if(node.getRight() != null){
            inOrderTraversal(node.getRight());
        }
    }

    public static void preOrderTraversal(TreeNode<Integer> node){
        System.out.print(node.getValue() + " ");

        if(node.getLeft() != null){
            preOrderTraversal(node.getLeft());
        }

        if(node.getRight() != null){
            preOrderTraversal(node.getRight());
        }
    }

    public static void postOrderTraversal(TreeNode<Integer> node){
        if(node.getLeft() != null){
            postOrderTraversal(node.getLeft());
        }

        if(node.getRight() != null){
            postOrderTraversal(node.getRight());
        }

        System.out.print(node.getValue() + " ");
    }
}
