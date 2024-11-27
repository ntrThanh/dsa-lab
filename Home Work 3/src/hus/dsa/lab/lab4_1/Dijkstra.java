package hus.dsa.lab.lab4_1;

import java.util.*;

public class Dijkstra {
    public Map<Node, Integer> dijkstraAlgorithm(Node root) {
        Map<Node, Integer> distance = new HashMap<>();
        PriorityQueue<NodeDistance> nodeDistances = new PriorityQueue<>(new Comparator<NodeDistance>() {
            @Override
            public int compare(NodeDistance o1, NodeDistance o2) {
                return o1.weight - o2.weight;
            }
        });
        Set<Node> set = new LinkedHashSet<>();

        distance.put(root, 0);
        nodeDistances.add(new NodeDistance(root, 0));

        while (!nodeDistances.isEmpty()) {
            NodeDistance node = nodeDistances.poll();
            Node curr = node.node;

            if (set.contains(curr)) {
                continue;
            } else {
                set.add(curr);
            }

            for (Neighbor neighbor : curr.list) {
                Node temp = neighbor.target;

                int newWeight = distance.getOrDefault(curr, Integer.MAX_VALUE) + neighbor.weight;

                if (newWeight < distance.getOrDefault(temp, Integer.MAX_VALUE)) {
                    distance.put(temp, newWeight);
                    nodeDistances.add(new NodeDistance(temp, newWeight));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(4);

        nodeA.list.add(new Neighbor(nodeB, 1));
        nodeA.list.add(new Neighbor(nodeC, 4));
        nodeB.list.add(new Neighbor(nodeC, 2));
        nodeB.list.add(new Neighbor(nodeD, 6));
        nodeC.list.add(new Neighbor(nodeD, 3));

        Map<Node, Integer> result = new Dijkstra().dijkstraAlgorithm(nodeA);

        for (Map.Entry<Node, Integer> entry : result.entrySet()) {
            System.out.println("Khoảng cách từ nodeA đến node " + entry.getKey().data + ": " + entry.getValue());
        }
    }
}

class Node {
    int data;
    List<Neighbor> list;

    public Node(int data, List<Neighbor> list) {
        this.data = data;
        this.list = list;
    }

    public Node() {
        data = Integer.MAX_VALUE;
        list = new ArrayList<>();
    }

    public Node(int data) {
        this.data = data;
        list = new ArrayList<>();
    }
}

class Neighbor {
    Node target;
    int weight;

    public Neighbor(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class NodeDistance {
    Node node;
    int weight;

    public NodeDistance(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

