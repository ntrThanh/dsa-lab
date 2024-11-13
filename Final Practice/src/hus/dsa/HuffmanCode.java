package hus.dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {
    class Node {
        String value;
        int priority;

        public Node(String value, int priority, Node left, Node right) {
            this.value = value;
            this.priority = priority;
            this.left = left;
            this.right = right;
        }

        Node left, right;


        public Node(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }

    public Node buildTree(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i) + "")) {
                map.put(s.charAt(i) + "", 1);
            } else {
                map.put(s.charAt(i) + "", map.get(s.charAt(i) + "") + 1);
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.priority == o2.priority) {
                    // Sắp xếp theo thứ tự bảng chữ cái khi tần số giống nhau
                    return o1.value.compareTo(o2.value);
                }
                return o1.priority - o2.priority;
            }
        });

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            priorityQueue.add(new Node(m.getKey(), m.getValue()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node curr = new Node(left.value + right.value,
                    left.priority + right.priority, left, right);
            priorityQueue.add(curr);
        }

        return priorityQueue.poll();
    }

    public void enCode(Node root, String code, Map<String, String> map) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            map.put(root.value, code);
        }

        enCode(root.left, code + "1", map);
        enCode(root.right, code + "0", map);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        new HuffmanCode().enCode(new HuffmanCode().buildTree("DHKHTN"), "", map);

        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + map.get(m.getKey()));
        }
    }
}
