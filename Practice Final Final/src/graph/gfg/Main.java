package graph.gfg;

import java.util.*;

public class Main {
    // chuyen tu danh sach canh sang danh sach ke
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] x : edges) {
            res.get(x[0]).add(x[1]);
            res.get(x[1]).add(x[0]);
        }

        return res;
    }


    // clone graph
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


    Node cloneGraph(Node node) {
        Node template = new Node(node.val);
        dfs(node, template, new HashSet<>());
        return template;
    }

    public void dfs(Node root, Node template, Set<Node> visited) {
        if (root == null) {
            return;
        }

        visited.add(root);

        for (Node neighbor : root.neighbors) {
            Node temp = new Node(neighbor.val);

            template.neighbors.add(temp);

            if (!visited.contains(neighbor)) {
                dfs(neighbor, temp, visited);
            }
        }
    }

    // duyet cay theo chieu sau
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        dfs(adj, res, 0, new boolean[adj.size()]);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, int index, boolean[] visited) {
        if (visited[index]) {
            return;
        }

        visited[index] = true;
        res.add(index);

        for (int neighbor : adj.get(index)) {
            if (!visited[neighbor]) {
                dfs(adj, res, neighbor, visited);
            }
        }
    }

    // duyet cay theo chieu rong

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            res.add(current);

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return res;
    }


    // kiem tra xem co la mach vong hay khong
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(adj, -1, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> list, int parent, int current, boolean[] visited) {
        visited[current] = true;

        for (int neighbor : list.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(list, current, neighbor, visited)) {
                    return true;
                }
            } else if (parent != neighbor) {
                return true;
            }
        }

        return false;
    }

    // kiem tra do thi co huong co manh vong hay khong
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (dfs(adj, i, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int index, int[] visited) {
        if (visited[index] == 1) {
            return true;
        }

        if (visited[index] == 2) {
            return false;
        }

        visited[index] = 1;

        for (int neighbor : adj.get(index)) {
            if (dfs(adj, neighbor, visited)) {
                return true;
            }
        }

        visited[index] = 2;
        return false;
    }

    // dem so dao
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    countIslands(grid, i, j);
                }
            }
        }

        return count;
    }

    public void countIslands(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';

        countIslands(grid, row + 1, col);
        countIslands(grid, row - 1, col);
        countIslands(grid, row, col + 1);
        countIslands(grid, row, col - 1);
        countIslands(grid, row + 1, col + 1);
        countIslands(grid, row + 1, col - 1);
        countIslands(grid, row - 1, col + 1);
        countIslands(grid, row - 1, col - 1);
    }

    // to mau
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, visited, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != oldColor) {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        dfs(image, sr + 1, sc, newColor, visited, oldColor);
        dfs(image, sr - 1, sc, newColor, visited, oldColor);
        dfs(image, sr, sc + 1, newColor, visited, oldColor);
        dfs(image, sr, sc - 1, newColor, visited, oldColor);
    }

    // kiem tra xem co la duong di euler khong
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        for (ArrayList<Integer> x : adj) {
            if (x.size() % 2 == 1) {
                return false;
            }
        }

        return true;
    }

    // duyet duoc tat ca cac canh va dinh
    public int isPossible(int[][] paths) {
        // Code here
        for (int i = 0; i < paths.length; i++) {
            int count = 0;
            for (int j = 0; j < paths[i].length; j++) {
                if (paths[i][j] == 1) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                return 0;
            }
        }
        return 1;
    }

    // hmt path
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // code here
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (ArrayList<Integer> curr : Edges) {
            adjacent.get(curr.get(0)).add(curr.get(1));
            adjacent.get(curr.get(1)).add(curr.get(0));
        }

        for (int i = 1; i <= N; i++) {
            if (dfs(adjacent, i, N, 1, new boolean[N + 1])) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> adjacent, int index, int size, int count, boolean[] visited) {
        visited[index] = true;

        if (count == size) {
            return true;
        }

        for (int neighbor : adjacent.get(index)) {
            if (!visited[neighbor]) {
                if (dfs(adjacent, neighbor, size, count + 1, visited)) {
                    return true;
                }
            }
        }

        visited[index] = false;
        return false;
    }


    // do thi hai phan
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);

        for (int i = 0; i < adj.size(); i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int current = queue.poll();

                    for (int neighbor : adj.get(current)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[current];
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[current]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    // so 1 gan nhat
    public int[][] nearest(int[][] grid) {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> positions = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    result[i][j] = 0;
                    positions.add(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] move1 = new int[]{-1, 1, 0, 0};
        int[] move2 = new int[]{0, 0, -1, 1};

        while (!positions.isEmpty()) {
            int[] currentPosition = positions.poll();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            for (int i = 0; i < 4; i++) {
                int x = currentRow + move1[i];
                int y = currentCol + move2[i];

                if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                    result[x][y] = result[currentRow][currentCol] + 1;
                    visited[x][y] = true;
                    positions.add(new int[]{x, y});
                }
            }
        }

        return result;
    }
}
