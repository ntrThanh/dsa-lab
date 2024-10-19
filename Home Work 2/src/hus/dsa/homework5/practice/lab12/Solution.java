package hus.dsa.homework5.practice.lab12;

import hus.dsa.homework5.practice.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        leftView(root, list);

        return list;
    }

    void leftView(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            leftView(root.left, list);
        } else {
            leftView(root.right, list);
        }

        list.add(root.data);
    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> list = new ArrayList<>();
        topView(root, list);

        return list;
    }

    private static void topView(Node root, ArrayList<Integer> list) {

    }
}
