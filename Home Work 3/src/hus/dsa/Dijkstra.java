package hus.dsa;

import java.util.Arrays;

public class Dijkstra {
    public void dijkstra(int[][] grid, int source) {
        int[] result = new int[grid.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        boolean[] visited = new boolean[grid.length];
        int[] path = new int[grid.length];
        Arrays.fill(path, -1);

        result[source] = 0;
        for (int i = 0; i < grid.length; i++) {
            int curr = minDistance(result, visited);

            visited[curr] = true;

            for (int j = 0; j < grid.length; j++) {
                if (!visited[j]
                        && grid[curr][j] != 0
                        && result[curr] != Integer.MAX_VALUE
                        && result[curr] + grid[curr][j] < result[j]) {

                    result[j] = result[curr] + grid[curr][j];
                    path[j] = curr;
                }
            }
        }

        print(result, path, source);
    }

    public int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && min > distance[i]) {
                min = distance[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    static void print(int[] data, int[] path, int source) {
        for (int i = 0; i < data.length; i++) {
            if (i != source) {
                System.out.print("Path from " + source + " to " + i + " ");
                if (data[i] == Integer.MAX_VALUE) {
                    System.out.println("Don't have path");
                } else {
                    System.out.print(data[i] + " min path is: ");
                    printMinPath(path, i);
                    System.out.println();
                }
            }
        }
    }

    public static void printMinPath(int[] path, int vertex) {
        if (path[vertex] == -1) {
            System.out.print(vertex);
            return;
        }

        printMinPath(path, path[vertex]);
        System.out.print(" -> " + vertex);
    }

    public static void main(String[] args) {
        int graph[][]
                = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        new Dijkstra().dijkstra(graph, 0);
    }

}
