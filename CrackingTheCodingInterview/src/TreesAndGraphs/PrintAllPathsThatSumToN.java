package TreesAndGraphs;

import TreesAndGraphs.Collections.BinaryTree;
import TreesAndGraphs.Collections.Path;
import TreesAndGraphs.Collections.TreeNode;

import java.util.*;

public class PrintAllPathsThatSumToN {
    private static int targetSum = 0;
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

        targetSum = 17;
        getNodePaths(root);
        System.out.println();
        targetSum = 27;
        getNodePaths(root);
    }

    // This version of the algorithm finds paths between any 2 nodes in the graph, not only between a node and a descendant.
    // So for example it can find a path between 2 leaves
    public static List<Path> getNodePaths(TreeNode<Integer> node){
        if(node == null){
            return null;
        }

        List<Path> leftPaths = getNodePaths(node.getLeft());
        List<Path> rightPaths = getNodePaths(node.getRight());
        List<Path> paths = new ArrayList<>();

        Path path = new Path(
                node.getValue(),
                new ArrayList<Integer>(){{
                    add(node.getValue());
                }});

        if(path.sum == targetSum){
            System.out.println(path.nodes);
        }

        paths.add(path);

        if(leftPaths != null && rightPaths != null){
            HashMap<Integer, List<Path>> pathsBySum = new HashMap<>();
            List<Path> extendedLeftPaths = extendPaths(leftPaths, node.getValue());
            for (Path extendedLeftPath : extendedLeftPaths) {
                paths.add(extendedLeftPath);
                if(!pathsBySum.containsKey(extendedLeftPath.sum)){
                    pathsBySum.put(extendedLeftPath.sum, new ArrayList<>());
                }

                pathsBySum.get(extendedLeftPath.sum).add(extendedLeftPath);
            }

            for (Path rightPath : rightPaths) {
                int compliment = targetSum - rightPath.sum;
                if(pathsBySum.containsKey(compliment)){
                    for (Path leftPath : pathsBySum.get(compliment)) {
                        System.out.println(createMergedPath(leftPath, rightPath).nodes);
                    }
                }
            }

            paths.addAll(extendPaths(rightPaths, node.getValue()));
        } else if(leftPaths != null || rightPaths != null){
            paths.addAll(extendPaths(leftPaths != null ? leftPaths : rightPaths, node.getValue()));
        }

        return paths;
    }

    private static List<Path> extendPaths(List<Path> partialPaths, int nodeValue){
        List<Path> newPaths = new ArrayList<>();
        for (Path partialPath : partialPaths) {
            List<Integer> pathNodes = new ArrayList<>(partialPath.nodes);
            pathNodes.add(nodeValue);
            int newSum = partialPath.sum + nodeValue;
            if(newSum == targetSum){
                System.out.println(pathNodes);
            }
            newPaths.add(new Path(newSum, pathNodes));
        }

        return newPaths;
    }

    private static Path createMergedPath(Path leftPath, Path rightPath){
        int newSum = leftPath.sum + rightPath.sum;
        List<Integer> pathNodes = new ArrayList<>(leftPath.nodes);

        // add rightPath nodes reversed
        for (int i = rightPath.nodes.size() - 1; i >= 0; i--) {
            pathNodes.add(rightPath.nodes.get(i));
        }

        //pathNodes.addAll(rightPath.nodes);
        return new Path(newSum, pathNodes);
    }

}
