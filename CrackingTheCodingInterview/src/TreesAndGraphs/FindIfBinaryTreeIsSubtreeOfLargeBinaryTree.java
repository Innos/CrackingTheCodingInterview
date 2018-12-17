package TreesAndGraphs;


import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

public class FindIfBinaryTreeIsSubtreeOfLargeBinaryTree {
    public static void main(String[] args) {
        //      4
        //    /  \
        //   2    6
        //  / \  / \
        // 3  0 5   8
        //  \      / \
        //   1    7  9
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(4);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value0 = new TreeNode<>(0);
        TreeNode<Integer> value1 = new TreeNode<>(1);
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value3 = new TreeNode<>(3);
        TreeNode<Integer> value5 = new TreeNode<>(5);
        TreeNode<Integer> value6 = new TreeNode<>(6);
        TreeNode<Integer> value7 = new TreeNode<>(7);
        TreeNode<Integer> value8 = new TreeNode<>(8);
        TreeNode<Integer> value9 = new TreeNode<>(9);
        root.setLeft(value2);
        root.setRight(value6);
        // not bst
        value2.setLeft(value3);
        value2.setRight(value0);
        value3.setRight(value1);
        value6.setLeft(value5);
        value6.setRight(value8);
        value8.setLeft(value7);
        value8.setRight(value9);

        // 3
        //  \
        //   1
        BinaryTree<Integer> t2 = new BinaryTree<>();
        t2.add(3);
        TreeNode<Integer> t2Root = t2.getRoot();
        TreeNode<Integer> node1 = new TreeNode<>(1);
        t2Root.setRight(node1);

        System.out.println(isSubtree(root, t2Root));

        //   3
        //  / \
        // 2   1
        TreeNode<Integer> node2 = new TreeNode<>(2);
        t2Root.setLeft(node2);

        System.out.println(isSubtree(root, t2Root));

        //   6
        //  / \
        // 5   8
        //    / \
        //   7  9
        BinaryTree<Integer> t3 = new BinaryTree<>();
        t3.add(6);
        TreeNode<Integer> t3Root = t3.getRoot();
        TreeNode<Integer> t3node5 = new TreeNode<>(5);
        TreeNode<Integer> t3node8 = new TreeNode<>(8);
        TreeNode<Integer> t3node7 = new TreeNode<>(7);
        TreeNode<Integer> t3node9 = new TreeNode<>(9);
        t3Root.setLeft(t3node5);
        t3Root.setRight(t3node8);
        t3node8.setLeft(t3node7);
        t3node8.setRight(t3node9);

        System.out.println(isSubtree(root, t3Root));
    }

    public static boolean isSubtree(TreeNode<Integer> t1Node, TreeNode<Integer> t2Node){
        if(t2Node == null){
            return true;
        }

        return findMatchinNode(t1Node, t2Node);
    }

    private static boolean findMatchinNode(TreeNode<Integer> t1Node, TreeNode<Integer> t2Node){
        if(t1Node == null){
            return false;
        }

        if(t1Node.getValue() == t2Node.getValue()){
            return compareTrees(t1Node, t2Node);
        }

        return findMatchinNode(t1Node.getLeft(), t2Node) || findMatchinNode(t1Node.getRight(), t2Node);
    }

    private static boolean compareTrees(TreeNode<Integer> t1Node, TreeNode<Integer> t2Node){
        if(t1Node == null && t2Node == null){
            return true;
        }

        if(t1Node == null || t2Node == null){
            return false;
        }

        if(t1Node.getValue() != t2Node.getValue()){
            return false;
        }

        return compareTrees(t1Node.getLeft(),t2Node.getLeft()) && compareTrees(t1Node.getRight(),t2Node.getRight());
    }

    //Based on the description T2 is considered subtree of T1 if there exists a node N in T1 such that if you cut
    // the subtree of N it will be identical to T2. Based on this description we can conclude that if a subtree match of T2
    // is found in T1, the leaves of the match will also be leaves in T1, otherwise the subtrees will not be identical

    //If the above is true and node values could be uniquely represented in string format, then a potential better algorithm would be:
    // 1. Preorder traverse T2 and construct a string representation (some unique separator different that potential node values can be appended
    // between nodes in order to differentiate them, for example if node values are ints we want to differentiate 1 from 11 in a string). In our
    // preorder traversal we should also print null children so that we have the complete tree structure and can differentiate between for example:
    //
    //    Tree 1                    Tree 2
    //
    //       1             and        1
    //      /                        / \
    //     1                        1   2
    //    /
    //   2
    //
    // Example representation:
    // Tree 1: 1 1 2 N N N N
    // Tree 2: 1 1 N N 2 N N
    //
    // 2. Start preorder traversing T1 appending each node value to a string builder
    // 3. After 2m nodes (where m is the size of T2) attempt to substring match T2 string pattern in current T1 string pattern
    // (fast string matching algorithms on large texts can be used like Boyer-Moore or Knuth-Morris-Prat) if the match succeeds,
    // then clearly T2 is a subtree of T1 and we are done, alternatively delete indexes 0...m-1 from T1 pattern, the logic being that
    // if T2 is a subtree in T1 and only a part of it has currently been traversed in T1, then the T2's pattern must be in the second half of
    // the current T1 pattern (since the T1 pattern has length of 2m and if it was before the center, it would have been matched).
    // This will allow us to use only O(m) extra memory
    // 4. Traverse another m nodes (appending them to the end of the string builder), then attempt to substring match T2 pattern in
    // T1 pattern again, if the match fails repeat step 4 until either the match succeeds or T1 runs out of nodes to traverse
}
