package hus.dsa.practice;

import java.util.*;

public class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            result.get(edges[i][0]).add(edges[i][1]);
            result.get(edges[i][1]).add(edges[i][0]);
        }

        return result;
    }

    Node cloneGraph(Node node) {
        Node temp = new Node(node.val);

        clone(node, new HashSet<>(), temp);
        return temp;
    }

    public void clone(Node root, Set<Node> visited, Node curr) {
        if (root == null) {
            return;
        }

        visited.add(root);

        for (Node neighbor : root.neighbors) {
            Node temp = new Node(neighbor.val);

            curr.neighbors.add(temp);

            if (!visited.contains(neighbor)) {
                clone(neighbor, visited, temp);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < adj.size(); i++) {
            if (!set.contains(i)) {
                dfs(adj, list, i, set);
            }
        }
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, int index, Set<Integer> visited) {
        visited.add(index);
        list.add(index);

        for (int i = 0; i < adj.get(index).size(); i++) {
            if (!visited.contains(adj.get(index).get(i))) {
                dfs(adj, list, adj.get(index).get(i), visited);
            }
        }
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[V];

        visited[0] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            list.add(temp);

            for (int i = 0; i < adj.get(temp).size(); i++) {
                if (!visited[adj.get(temp).get(i)]) {
                    queue.add(adj.get(temp).get(i));
                    visited[adj.get(temp).get(i)] = true;
                }
            }
        }


        return list;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];

        return dfsCycle(adj, -1, 0, visited); // nguoc lai tra ve false;
    }

    public boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, int parent, int current, boolean[] visited) {
        visited[current] = true;

        for (int i : adj.get(current)) {
            if (!visited[i]) {
                if (dfsCycle(adj, current, i, visited)) {
                    return true;
                }
            } else if (parent != i) { // neu da gap mot nut duoc tham lai, kiem tra xem co phai th dac biet khong
                // thdb (parrent == i) tuc hai nut tu lien ket 2 chieu voi nhau
                return true;
            }
        }

        return false;
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

    public int isPossible(int[][] paths) {
        // Code here

        for (int i = 0; i < paths.length; i++) {
            int curr = 0;

            for (int j = 0; j < paths.length; j++) {
                if (paths[i][j] != 0) {
                    curr++;
                }
            }

            if (curr % 2 != 0) {
                return 0;
            }
        }

        return 1;
    }

    public int findMaxArea(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int[] count = new int[1];
                    dfsArea(grid, visited, i, j, count);
                    max = Math.max(max, count[0]);
                }
            }
        }
        return max;
    }

    public void dfsArea(int[][] grid, boolean[][] visited, int x, int y, int[] count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        count[0]++;

        dfsArea(grid, visited, x + 1, y, count);
        dfsArea(grid, visited, x - 1, y, count);
        dfsArea(grid, visited, x, y + 1, count);
        dfsArea(grid, visited, x, y - 1, count);
        dfsArea(grid, visited, x - 1, y - 1, count);
        dfsArea(grid, visited, x + 1, y + 1, count);
        dfsArea(grid, visited, x + 1, y - 1, count);
        dfsArea(grid, visited, x - 1, y + 1, count);
    }

    public static void main(String[] args) {
        new Solution().nearest(new int[][]{
                {
                        0, 1, 1, 0
                },
                {
                        1, 1, 0, 0
                },
                {
                        0, 0, 1, 1
                }
        });

    }

    // 1010 test case / 1115
    public int[][] nearest(int[][] grid) {
        // Code here
        int[][] arr = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    arr[i][j] = 0;
                    continue;
                } else {
                    boolean[][] visited = new boolean[grid.length][grid[i].length];
                    arr[i][j] = dfsNearest(grid, i, j, visited);
                }

            }
        }

        return arr;
    }

    public int dfsNearest(int[][] grid, int x, int y, boolean[][] visited) {
        int maxDistance = grid.length + grid[0].length;

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return maxDistance;
        }

        if (grid[x][y] == 1) {
            return 0;
        }

        visited[x][y] = true;
        int left = dfsNearest(grid, x, y - 1, visited);
        int right = dfsNearest(grid, x, y + 1, visited);
        int up = dfsNearest(grid, x + 1, y, visited);
        int down = dfsNearest(grid, x - 1, y, visited);
        visited[x][y] = false;

        return 1 + Math.min(Math.min(left, right), Math.min(up, down));
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);

        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                color[i] = 0;
                queue.add(color[i]);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int u : adj.get(curr)) {
                        if (color[u] == -1) {
                            color[u] = 1 - color[curr];
                            queue.add(u);
                        } else if (color[u] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public int numIslands(char[][] grid) {
        // Code here
        int result = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isIsland(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    public boolean isIsland(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return false;
        }

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                    continue;
                }

                if (grid[i][j] == '1') {
                    if (x == i && y == j) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

class Node {
    int val;
    ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
