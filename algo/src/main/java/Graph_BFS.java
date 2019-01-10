import util.Graph;

import java.util.*;

public class Graph_BFS {
    public static Map<Integer, List<Integer>> breathFirstSearch(Graph graph, int startingPoint) {
        Map<Integer, List<Integer>> theMap = getInitialMap(graph.numberOfVertex,startingPoint);

        Queue queue = new LinkedList();
        List<Integer> visited = new ArrayList<>();
        queue.add(startingPoint);

        while(!queue.isEmpty()){
            Integer v = (Integer) queue.remove();
            visited.add(v);

            List<Integer> neighbours = graph.getNeighbours(v);
            for (Integer neighbour : neighbours) {
                if(!visited.contains(neighbour) && !queue.contains(neighbour)){
                    queue.add(neighbour);
                    addPath(theMap, v, neighbour);
                }
            }
        }

        return theMap;
    }


    private static Map<Integer, List<Integer>> getInitialMap(int numberOfVertex, int startingPoint) {
        Map<Integer, List<Integer>> theMap = new HashMap<>();
        for(int i = 0 ; i< numberOfVertex; i++){
            LinkedList<Integer> path = new LinkedList<>();
            if(i==startingPoint){
                path.add(startingPoint);
            }

            theMap.put(i,path);
        }
        return theMap;
    }

    private static void addPath(Map<Integer, List<Integer>> theMap, Integer v, Integer neighbour) {
            theMap.get(neighbour).addAll(theMap.get(v));
            theMap.get(neighbour).add(neighbour);
    }

    public static void main(String[] args) {
        System.out.println(" ----- traverse from v0 -----");
        breathFirstSearch(Graph.getInstance_edgeWithoutWeight(),0).forEach((k,v)-> System.out.println("vertex:" + k + " path: " + v.toString()));

        System.out.println(" ----- traverse from v3 -----");
        breathFirstSearch(Graph.getInstance_edgeWithoutWeight(),3).forEach((k,v)-> System.out.println("vertex:" + k + " path: " + v.toString()));

    }
}
