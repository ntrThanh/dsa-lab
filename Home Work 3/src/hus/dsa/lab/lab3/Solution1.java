package hus.dsa.lab.lab3;

import hus.dsa.lab.lab1.Solution;

public class Solution1 {
    public static void main(String[] args) {
        Solution graph = new Solution();

        graph.loadGraphByFile("C:\\Users\\Trong Thanh\\Documents\\Data Structure\\LabInSchool\\src\\dsa\\graph\\TestData.txt");

        graph.matrixPrint();

        System.out.print("so canh: ");
        System.out.print(graph.edges().size());
        System.out.println();

        System.out.print("bac cua K: " + graph.vertices("k").size() + "cac ket noi la: ");
        graph.vertices("K").forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("ket noi dinh K va B " + graph.isConnect("K", "B"));
        System.out.println("ket noi dinh H va D " + graph.isConnect("H", "D"));

        System.out.println("chen phan tu X");
        graph.insertVertex("X");
        graph.matrixPrint();

        System.out.println("xoa phan tu B");
        graph.removeVertex("B");
        graph.matrixPrint();
    }
}
