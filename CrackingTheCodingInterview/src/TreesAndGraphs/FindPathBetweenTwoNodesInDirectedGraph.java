package TreesAndGraphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class FindPathBetweenTwoNodesInDirectedGraph {
    public static void main(String[] args) {
        //    0
        //    ?
        //    1?2
        //    ?  ?
        //    4?3
        List<List<Integer>> graph = new ArrayList<>();

        int nodes = 5;
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(1);

        // Find path 0 -> 4
        System.out.println("Graph1 has path between 0 -> 4: " + containsPathBetween(0, 4, graph));


        //    0?1?2?3
        //         ? ?
        //         4?
        List<List<Integer>> graph2 = new ArrayList<>();

        int nodes2 = 5;
        for (int i = 0; i < nodes2; i++) {
            graph2.add(new ArrayList<>());
        }

        graph2.get(0).add(1);
        graph2.get(1).add(2);
        graph2.get(3).add(2);
        graph2.get(4).add(2);
        graph2.get(4).add(3);

        //Find path 1 -> 4
        System.out.println("Graph2 has path between 1 -> 4: " + containsPathBetween(1, 4, graph2));
    }

    public static boolean containsPathBetween(int start, int end, List<List<Integer>> graph){
        boolean startHasNoOutgoingEdges = graph.get(start).isEmpty();
        boolean endHasNoOutgoingEdges = graph.get(end).isEmpty();

        if(startHasNoOutgoingEdges && endHasNoOutgoingEdges){
            return false;
        } else if(startHasNoOutgoingEdges){
            return hasPathBfs(end,start,graph);
        } else if(endHasNoOutgoingEdges){
            return hasPathBfs(start,end,graph);
        } else {
            return hasPathBfs(start,end,graph) || hasPathBfs(end,start,graph);
        }
    }

    public static boolean hasPathBfs(int start, int end, List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();

            if(current == end){
                return true;
            }

            for (int i = 0; i < graph.get(current).size(); i++) {
                int child = graph.get(current).get(i);
                if(!visited[child]){
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

        return false;
    }
}
