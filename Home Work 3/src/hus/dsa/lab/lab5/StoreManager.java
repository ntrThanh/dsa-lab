package hus.dsa.lab.lab5;

import java.io.File;
import java.util.*;

public class StoreManager {
    int[][] matrix;
    private Map<Store, Integer> map;
    private List<Store> list;

    public void loadStoreByFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int n = Integer.parseInt(sc.nextLine());

            matrix = new int[n][n];
            map = new HashMap<>();
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String currString = sc.nextLine();

                String[] cellOfString = currString.split(" \\| ");
                int id = Integer.parseInt(cellOfString[0]);
                String name = cellOfString[1];
                boolean isMain = Boolean.parseBoolean(cellOfString[2]);
                String address = cellOfString[3];
                int total = Integer.parseInt(cellOfString[4]);
                Store store = new Store(id, name, isMain, address, total);

                list.add(store);
                map.put(store, i);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

        } catch (Exception e) {
            e.getCause();
        }
    }

    public void addStore(int id, String name, boolean isMain, String address, int total) {
        Store store = new Store(id, name, isMain, address, total);

        int[][] newMatrix = new int[matrix.length + 1][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = newMatrix;
        map.put(store, list.size());
        list.add(store);
    }

    public void insertPath(Store left, Store right, int x) {
        int leftIdx = map.getOrDefault(left, -1);
        int rightIdx = map.getOrDefault(right, -1);

        if (leftIdx == -1 || rightIdx == -1) {
            return;
        } else {
            matrix[leftIdx][rightIdx] = x;
        }
    }

    public void removeStore(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                removeStore(list.get(i));
                return;
            }
        }
    }
    public void removeStore(Store store) {
        int index = map.getOrDefault(store, -1);
        list.remove(store);
        Map<Store, Integer> map1 = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        removeIdx(index);
    }

    private void removeIdx(int index) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];

        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (i == index) {
                continue;
            }

            for (int j = 0; j < matrix.length; j++) {
                if (j == index) {
                    continue;
                }

                list1.add(matrix[i][j]);
            }
        }

        int count = 0;

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[i][j] = list1.get(count + 1);
            }
        }

        matrix = newMatrix;
    }

    public int[] findShortestPath(int[][] matrix) {
        int[] result = new int[matrix.length];
        boolean[] visited = new boolean[matrix.length];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 0; i < matrix.length; i++) {
            int curr = minPath(result, visited);

            visited[curr] = true;

            for (int j = 0; j < matrix.length; j++) {
                if (!visited[j]
                        && matrix[curr][j] != 0
                        && result[curr] != Integer.MAX_VALUE
                        && result[curr] + matrix[curr][j] < result[j]) {
                    result[j] = result[curr] + matrix[curr][j];
                }
            }
        }

        return result;
    }

    public int minPath(int[] path, boolean[] visited) {
        int min = Integer.MAX_VALUE;

        int minIdx = -1;

        for (int i = 0; i < path.length; i++) {
            if (min > path[i] && !visited[i]) {
                min = path[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    public void path(Store b) {
        int[] result = findShortestPath(matrix);

        int idx = map.getOrDefault(b, -1);

        if (idx == -1) {
            System.out.println("No path from root to " + b.getName());
            return;
        }

        System.out.println("Min path from root to " + b.getName() + " is: " + result[idx]);
    }

    public void getMinPath() {
        int[] result = findShortestPath(matrix);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Min path from root to " + list.get(i).getName() + " is: " + result[i]);
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Map<Store, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Store, Integer> map) {
        this.map = map;
    }

    public List<Store> getList() {
        return list;
    }

    public void setList(List<Store> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        String file = "C:\\Users\\Trong Thanh\\Documents\\Data Structure\\Home Work 3\\src\\hus\\dsa\\lab\\lab5\\TestData.txt";
        StoreManager storeManager = new StoreManager();
        storeManager.loadStoreByFile(file);

        System.out.println("List of store is");
        storeManager.getList().forEach(System.out::println);

        System.out.println("Min path from root");
        storeManager.getMinPath();

        storeManager.removeStore("Circle K 1");
        storeManager.getList().forEach(System.out::println);
    }
}
