import util.Node;

import java.util.*;

public class BFS {
    public static List<Node> getShortestPath(Node start, Node end) {
        Map<Node, Integer> journeyTracker = new HashMap<>();

        Queue queue = new LinkedList<>();
        int numOfEdges = 0;

        queue.add(start);
        journeyTracker.put(start, 0);
        while (!queue.isEmpty()) {
            Node node = (Node) queue.remove();

            if (node.name.equalsIgnoreCase(end.name)) {
                System.out.println("Reached the destination! ");
                break;
            }

            numOfEdges++;
            List<Node> neighbours = node.neighbours;
            for (Node neighbour : neighbours) {
                if (!journeyTracker.containsKey(neighbour)) {
                    queue.add(neighbour);
                    journeyTracker.put(neighbour, numOfEdges);
                }
            }
        }

        return getPath(journeyTracker, start, end);
    }

    private static List<Node> getPath(Map<Node, Integer> journeyTracker, Node start, Node end) {
        LinkedList path = new LinkedList();
        Node node = end;

        while (node != null) {
            path.addFirst(node);
            node = getMostClosedPredecessor(node, journeyTracker);
        }

        return path;

    }

    private static Node getMostClosedPredecessor(Node node, Map<Node, Integer> journeyTracker) {
        List<Node> predecessors = node.getPredecessors();
        Node mostClosedPredecessor = null;
        int distance = Integer.MAX_VALUE;
        for (Node predecessor : predecessors) {
            int d = journeyTracker.get(predecessor);
            if (d < distance) {
                distance = d;
                mostClosedPredecessor = predecessor;
            }
        }

        return mostClosedPredecessor;
    }

    public static void main(String[] args) {

    }
}
