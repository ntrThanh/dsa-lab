package hus.dsa.practice;

import java.util.*;

public class Algorithm {
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adjacent) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < adjacent.size(); i++) {
            if (!visited.contains(i)) {
                dfs(result, adjacent, i, visited);
            }
        }
        return result;
    }

    public static void dfs(List<Integer> result, ArrayList<ArrayList<Integer>> adjacent, int index, Set<Integer> visited) {
        result.add(index);
        visited.add(index);

        // dfs with neighbor of index
        for (Integer u : adjacent.get(index)) {

            // check u is visited ?
            if (!visited.contains(u)) {
                dfs(result, adjacent, u, visited);
            }
        }
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            visited.add(curr);

            for (int neighbors : adj.get(curr)) {
                if (!visited.contains(neighbors)) {
                    queue.add(neighbors);
                }
            }
        }

        return list;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfsCycle(adj, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (int neighbors : adj.get(current)) {
            if (!visited[neighbors]) {
                if (dfsCycle(adj, visited, neighbors, current)) {
                    return true;
                }
            } else if (parent != neighbors) {
                return true;
            }
        }

        return false;
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);

        for (int i = 0; i < color.length; i++) {
            if (color[i] != -1) {
                Queue<Integer> queue = new LinkedList<>();
                color[i] = 0;
                queue.add(color[i]);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int neighbor : adj.get(curr)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[curr];
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


}
