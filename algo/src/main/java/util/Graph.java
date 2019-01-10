package util;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int[] vertices;
    public int numberOfVertex;
    public int[][] edges;
    private static int i = Integer.MAX_VALUE;

    /**
     *  0-------1--------2--------5
     *  |       /        |        /
     *  |      /         |       /
     *  |     /          |      /
     *  |    /           |     /
     *  |   /            |    /
     *  |  /             |   /
     *  | /              |  /
     *  3----------------4
     */
    public static Graph getInstance_edgeWithoutWeight() {
        Graph graph = new Graph();
        graph.vertices = new int[]{0, 1, 2, 3, 4, 5};
        graph.numberOfVertex = 6;
        graph.edges = new int[][]{
                {0, 1, i, 1, i, i},
                {1, 0, 1, 1, i, i},
                {i, 1, 0, i, 1, 1},
                {1, 1, i, 0, 1, i},
                {i, i, 1, 1, 0, 1},
                {i, i, 1, i, 1, 0}
        };
        return graph;
    }

    /**
     *  0-------1--------2--------5
     *  |       /        |        /
     *  |      /         |       /
     *  |     /          |      /
     *  |    /           |     /
     *  |   /            |    /
     *  |  /             |   /
     *  | /              |  /
     *  3----------------4
     */
    public static Graph getInstance_edgeWithWeight() {
        Graph graph = new Graph();
        graph.vertices = new int[]{0, 1, 2, 3, 4, 5};
        graph.numberOfVertex = 6;
        graph.edges = new int[][]{
                {0, 3, i, 1, i, i},
                {3, 0, 5, 2, i, i},
                {i, 5, 0, i, 4, 2},
                {1, 2, i, 0, 3, i},
                {i, i, 4, 3, 0, 1},
                {i, i, 2, i, 1, 0}
        };
        return graph;
    }

    public List<Integer> getNeighbours(int vertex) {
        List<Integer> neighbours = new ArrayList<>();
        for (int v = 0; v < numberOfVertex; v++) {
            if (edges[vertex][v] != 0 && edges[vertex][v] < Integer.MAX_VALUE) {
                neighbours.add(v);
            }
        }
        return neighbours;
    }
}
