package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.TreeNode;

import java.io.FileInputStream;
import java.util.LinkedHashMap;


public class FindLCAWithoutKeepingNodesInCollections {
    private static LinkedHashMap<TreeNode<Integer>, TreeNode<Integer>> ancestors = new LinkedHashMap<>();
    private static LinkedHashMap<TreeNode<Integer>, TreeNode<Integer>> parents = new LinkedHashMap<>();
    private static LinkedHashMap<TreeNode<Integer>, Integer> rank = new LinkedHashMap<>();
    private static LinkedHashMap<TreeNode<Integer>, Boolean> isBlack = new LinkedHashMap<>();
    private static TreeNode<Integer> lowestCommonAncestor = null;
    private static boolean foundLca = false;

    public static void main(String[] args) {
        //      5
        //    /  \
        //   3    7
        //  / \  / \
        // 4  1 6   9
        //  \      / \
        //   2    8  10

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        TreeNode<Integer> root = tree.getRoot();
        TreeNode<Integer> value1 = new TreeNode<>(1);
        TreeNode<Integer> value2 = new TreeNode<>(2);
        TreeNode<Integer> value3 = new TreeNode<>(3);
        TreeNode<Integer> value4 = new TreeNode<>(4);
        TreeNode<Integer> value6 = new TreeNode<>(6);
        TreeNode<Integer> value7 = new TreeNode<>(7);
        TreeNode<Integer> value8 = new TreeNode<>(8);
        TreeNode<Integer> value9 = new TreeNode<>(9);
        TreeNode<Integer> value10 = new TreeNode<>(10);
        root.setLeft(value3);
        root.setRight(value7);
        // not bst
        value3.setLeft(value4);
        value3.setRight(value1);
        value4.setRight(value2);
        value7.setLeft(value6);
        value7.setRight(value9);
        value9.setLeft(value8);
        value9.setRight(value10);

        // Find LCA of node 1 and node 2
        tarjanOlca(root, value1, value2);
        System.out.println(lowestCommonAncestor.getValue());

        TreeNode<Integer> newNode = new TreeNode<>(11);
        TreeNode<Integer> lca = findLca(root, value6, value8);
        System.out.println(foundLca ? lca.getValue() : "none");

        foundLca = false;
        TreeNode<Integer> lca2 = findLca(root, value1, newNode);
        System.out.println(foundLca ? lca2.getValue() : "none");
    }

    public static TreeNode<Integer> findLca(
            TreeNode<Integer> root,
            TreeNode<Integer> a,
            TreeNode<Integer> b){
        if(root == null){
            return null;
        }

        if(root == a && root == b){
            return root;
        }

        TreeNode<Integer> left = findLca(root.getLeft(), a, b);
        if(foundLca){
            return left;
        }

        TreeNode<Integer> right = findLca(root.getRight(), a, b);
        if(foundLca){
            return right;
        }

        if(left != null && right != null){
            foundLca = true;
            return root;
        }

        if(root == a || root == b){
            if(left != null || right != null){
                foundLca = true;
            }

            return root;
        }

        return left != null ? left : right;
    }


    // This implementation is heavier and uses multiple hashMaps for extra storage, but can work with nodes which have duplicate values
    public static void tarjanOlca(
            TreeNode<Integer> root,
            TreeNode<Integer> node1,
            TreeNode<Integer> node2){

        if(lowestCommonAncestor != null){
            return;
        }

        MakeSet(root);
        ancestors.put(root, root);
        if(root.getLeft() != null){
            tarjanOlca(root.getLeft(), node1, node2);
            Union(root, root.getLeft());
            ancestors.put(Find(root),root);
        }

        if(lowestCommonAncestor != null){
            return;
        }

        if(root.getRight() != null){
            tarjanOlca(root.getRight(), node1, node2);
            Union(root, root.getRight());
            ancestors.put(Find(root),root);
        }

        isBlack.put(root, true);

        if(lowestCommonAncestor == null && root == node1 && isBlack.containsKey(node2) && isBlack.get(node2)){
            lowestCommonAncestor = ancestors.get(Find(node2));
        }

        if(lowestCommonAncestor == null && root == node2 && isBlack.containsKey(node1) && isBlack.get(node1)){
            lowestCommonAncestor = ancestors.get(Find(node1));
        }
    }

    private static void MakeSet(TreeNode<Integer> node){
        parents.put(node, node);
        rank.put(node, 1);
    }

    private static void Union(TreeNode<Integer> a, TreeNode<Integer> b){
        TreeNode<Integer> aRoot = Find(a);
        TreeNode<Integer> bRoot = Find(b);
        if(rank.get(aRoot) > rank.get(bRoot)){
            parents.put(bRoot,aRoot);
        } else if(rank.get(aRoot) < rank.get(bRoot)){
            parents.put(aRoot,bRoot);
        } else {
            parents.put(bRoot, aRoot);
            rank.put(aRoot, rank.get(aRoot) + 1);
        }
    }

    private static TreeNode<Integer> Find(TreeNode<Integer> node){
        if(node != parents.get(node)){
            parents.put(node, Find(parents.get(node)));
        }

        return parents.get(node);
    }
}
