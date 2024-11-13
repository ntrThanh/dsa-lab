package hus.dsa.datastructure.finalpractice.huffmancode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    class Node implements Comparable<Node> {
        String data;
        int priority;

        Node left, right;

        public Node(String data, int priority, Node left, Node right) {
            this.data = data;
            this.priority = priority;
            this.left = left;
            this.right = right;
        }

        public Node(String data, int priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node o) {
            return priority - o.priority;
        }
    }

    public Node buildTreeWithString(String s) {
        s = s.toLowerCase().trim();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i) + "")) {
                map.put(s.charAt(i) + "", 1);
            } else {
                map.put(s.charAt(i) + "", map.get(s.charAt(i) + "") + 1);
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node root = new Node(left.data + right.data,
                    left.priority + right.priority, left, right);
            priorityQueue.add(root);
        }

        return priorityQueue.poll();
    }

    public void encode(Node root, String code,Map<String, String> map) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (!" ".contains(root.data)) {
                map.put(root.data, code);
            }
        }

        encode(root.left, code + "0", map);
        encode(root.right, code + "1", map);
    }

    public static void main(String[] args) {
        Map<String, String> result = new HashMap<>();

        new Huffman().encode(new Huffman().buildTreeWithString("DHKHTN"), "", result);

        for (Map.Entry<String, String> m : result.entrySet()) {
            System.out.print(m.getKey() + " code is: " + m.getValue());
            System.out.println();
        }
    }
}
