package hus.dsa.lab.lab1;

import java.io.File;
import java.util.*;

public class Solution {
    int[][] matrix;
    Map<String, Integer> vertexToIndex;
    List<String> vertex;

    public void loadGraphByFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int n = Integer.parseInt(sc.nextLine());

            matrix = new int[n][n];
            vertexToIndex = new HashMap<>();
            vertex = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                vertex.add(s);
                vertexToIndex.put(s, i);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            sc.close();

        } catch (Exception e) {
            e.getCause();
        }
    }

    public boolean isConnect(String u, String v) {
        int uIdx = vertexToIndex.getOrDefault(u, -1);
        int vIdx = vertexToIndex.getOrDefault(v, -1);

        if (uIdx == -1 || vIdx == -1) {
            return false;
        }

        return matrix[uIdx][vIdx] != 0;
    }

    public List<String> vertices(String u) {
        List<String> result = new LinkedList<>();

        for (int i = 0; i < vertex.size(); i++) {
            if (!u.equals(vertex.get(i)) && isConnect(vertex.get(i), u)) {
                result.add(vertex.get(i));
            }
        }

        return result;
    }

    public int numEdges() {
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    result++;
                }
            }
        }

        return result / 2;
    }

    public List<Integer> edges() {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }

    public Integer getEdge(String u, String v) {
        int uid = vertexToIndex.get(u);
        int vid = vertexToIndex.get(v);

        int result = matrix[uid][vid];

        if (result != 0) {
            return result;
        } else {
            return null;
        }
    }

    public String endVertices(int edge) {
        return null;
    }

    public String opposite(String u, int edge) {
        int uid = vertexToIndex.get(u);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[uid][i] == edge) {
                return vertex.get(i);
            }
        }

        return null;
    }

    public int outDegree(String v) {
        int uid = vertexToIndex.get(v);
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[uid][i] != 0) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> outgoingEdges(String v) {
        List<Integer> list = new ArrayList<>();
        int uid = vertexToIndex.get(v);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[uid][i] != 0) {
                list.add(matrix[uid][i]);
            }
        }

        return list;
    }

    public void insertVertex(String x) {
        int[][] newMatrix = new int[matrix.length + 1][matrix.length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        vertexToIndex.put(x, vertex.size());
        vertex.add(x);

        matrix = newMatrix;
    }

    public void insertEdge(String u, String v, int x) {
        int uid = vertexToIndex.get(u);
        int vid = vertexToIndex.get(v);

        matrix[uid][vid] = x;
    }

    public void removeVertex(String u) {
        if (!vertex.contains(u)) {
            return;
        }

        int uid = vertexToIndex.get(u);

        vertex.remove(u);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < vertex.size(); i++) {
            map.put(vertex.get(i), i);
        }

        vertexToIndex = map;
        removeColAndRow(uid);
    }

    private void removeColAndRow(int index) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (i == index) {
                continue;
            }

            for (int j = 0; j < matrix.length; j++) {
                if (j == index) {
                    continue;
                }

                list.add(matrix[i][j]);
            }
        }

        int count = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[i][j] = list.get(count++);
            }
        }

        matrix = newMatrix;
    }

    public void removeEdge(int edge) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == edge) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void matrixPrint() {
        System.out.println();
        System.out.println("Adjacent matrix");
        System.out.printf("%10s", "+");

        for (String s : vertex) {
            System.out.printf("%10s", s);
        }

        System.out.println();

        for (int i = 0; i < vertex.size(); i++) {
            System.out.printf("%10s", vertex.get(i));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%10d", matrix[i][j]);
            }

            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution graph = new Solution();
        graph.loadGraphByFile("C:\\Users\\Trong Thanh\\Documents\\Data Structure\\LabInSchool\\src\\dsa\\graph\\TestData.txt");
        graph.matrixPrint();

        System.out.println();

        graph.removeVertex("B");
        graph.matrixPrint();

        graph.insertVertex("X");
        graph.matrixPrint();
    }
}
