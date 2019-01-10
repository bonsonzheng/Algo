import javafx.util.Pair;
import util.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph_Dijkstra {
    public static Map<Integer, Pair<Integer, Integer>> getShortestPath(Graph graph, int startingPoint) {
        Map<Integer, Pair<Integer, Integer>> theMap = getInitialMap(graph.numberOfVertex, startingPoint);

        List<Integer> unvisited = Arrays.stream(graph.vertices).boxed().collect(Collectors.toList());

        while (!unvisited.isEmpty()) {
            Integer v = getShortestUnvisited(unvisited, theMap);
            unvisited.remove(v);

            List<Integer> neighbours = graph.getNeighbours(v);
            reevaluateDistanceToStartingPoint(graph, theMap, v, neighbours);
        }

        return theMap;
    }

    private static Map<Integer, Pair<Integer, Integer>> getInitialMap(int numberOfVertex, int startingPoint) {
        Map<Integer, Pair<Integer, Integer>> theMap = new HashMap<>();
        for (int i = 0; i < numberOfVertex; i++) {
            int initialValue = i == startingPoint ? 0 : Integer.MAX_VALUE;
            theMap.put(i, new Pair(startingPoint, initialValue));
        }

        return theMap;
    }

    private static Integer getShortestUnvisited(List<Integer> unvisited, Map<Integer, Pair<Integer, Integer>> theMap) {
        Integer target = unvisited.get(0);
        int distance = theMap.get(target).getKey();
        for (Integer v : unvisited) {
            Integer d = theMap.get(v).getValue();
            if (d < distance) {
                target = v;
                distance = d;
            }
        }
        return target;
    }

    private static void reevaluateDistanceToStartingPoint(Graph graph, Map<Integer, Pair<Integer, Integer>> theMap, Integer v, List<Integer> neighbours) {
        for (Integer neighbour : neighbours) {
            int d = theMap.get(v).getValue() + graph.edges[v][neighbour];
            if (theMap.get(neighbour).getValue() > d) {
                theMap.put(neighbour, new Pair(v, d));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("------------ Shortest path to V0 ------------------");
        getShortestPath(Graph.getInstance_edgeWithWeight(),0).forEach((k,v)-> System.out.println("vertex: " + k + " distance: " + v.getValue() + " via vertex " + v.getKey()));

        System.out.println("------------ Shortest path to V4 ------------------");
        getShortestPath(Graph.getInstance_edgeWithWeight(),4).forEach((k,v)-> System.out.println("vertex: " + k + " distance: " + v.getValue() + " via vertex " + v.getKey()));

        System.out.println("------------ Shortest path to V3 ------------------");
        getShortestPath(Graph.getInstance_edgeWithWeight(),3).forEach((k,v)-> System.out.println("vertex: " + k + " distance: " + v.getValue() + " via vertex " + v.getKey()));
    }
}
