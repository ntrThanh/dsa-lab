package hus.dsa.homework5.practice.lab9;

import hus.dsa.homework5.practice.Node;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        noSibling(node, list);

        if (list.isEmpty()) {
            list.add(-1);
        }

        Collections.sort(list);

        return list;
    }

    void noSibling(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left == null && node.right != null) {
            list.add(node.right.data);

        }

        if (node.right == null && node.left != null) {
            list.add(node.left.data);

        }

        noSibling(node.right, list);
        noSibling(node.left, list);
    }
}