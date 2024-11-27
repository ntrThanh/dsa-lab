package hus.dsa.lab.lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAlgorithm {
    public List<Node> BFS(Node graphRoot) {
        List<Node> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(graphRoot);
        result.add(graphRoot);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (!result.contains(temp)) {
                result.add(temp);
            }

            for (int i = 0; i < temp.list.size(); i++) {
                if (!result.contains(temp.list.get(i))) {
                    queue.add(temp.list.get(i));
                }
            }
        }

        return result;
    }

    public List<Node> DFS(Node graphRoot) {
        List<Node> result = new ArrayList<>();

        dfs(graphRoot, result);
        
        return result;
    }
    
    private void dfs(Node graphRoot, List<Node> list) {
        if (graphRoot == null) {
            return;
        }

        if (graphRoot.list.isEmpty()) {
            return;
        }

        if (!list.contains(graphRoot)) {
            list.add(graphRoot);
        }

        for (int i = 0; i < graphRoot.list.size(); i++) {
            if (!list.contains(graphRoot.list.get(i))) {
                dfs(graphRoot.list.get(i), list);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        boolean[][] visited = new boolean[image.length][image.length];
        int[][] curr = image.clone();

        flood(curr, sr, sc, newColor, visited, image[sr][sc]);
        return curr;
    }

    public void flood(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int oldColor) {
        if (visited[sr][sc]) {
            return;
        }

        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            flood(image, sr - 1, sc, newColor, visited, oldColor);
        }

        if (sr < image.length - 1 && image[sr + 1][sc] == oldColor) {
            flood(image, sr + 1, sc, newColor, visited, oldColor);
        }

        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            flood(image, sr, sc - 1, newColor, visited, oldColor);
        }

        if (sc < image[sr].length - 1 && image[sr][sc + 1] == oldColor) {
            flood(image, sr, sc + 1, newColor, visited, oldColor);
        }
    }

    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean isEuler = true;

        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() % 2 == 1) {
                return false;
            }
        }

        return isEuler;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(10);
        Node node3 = new Node(8);
        Node node4 = new Node(11);
        Node node5 = new Node(9);

        node1.list.add(node2); // 7
        node1.list.add(node3);

        node2.list.add(node1); // 10
        node2.list.add(node3);
        node2.list.add(node4);

        node3.list.add(node1); // 8
        node3.list.add(node2);
        node3.list.add(node4);
        node3.list.add(node5);

        node5.list.add(node3); // 9
        node5.list.add(node4);

        node4.list.add(node5); // 11
        node4.list.add(node3);
        node4.list.add(node2);

        /*
        * 7 ----- 8 -- 9
        *   \    / \   |
        *    \  /   \  |
        *     10 ---- 11
        * */

        new GraphAlgorithm().BFS(node1).forEach(x -> System.out.print(x.data + " "));
        System.out.println();
        new GraphAlgorithm().DFS(node1).forEach(x -> System.out.print(x.data + " "));
    }
}

class Node {
    int data;
    List<Node> list;

    public Node() {
        data = Integer.MIN_VALUE;
        list = new ArrayList<>();
    }

    public Node(int data) {
        this.data = data;
        list = new ArrayList<>();
    }
}

