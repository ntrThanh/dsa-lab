package hus.dsa.homework5.practice.lab13;

import java.util.*;

public class Solution {
    public Tree convert(Node head, Tree node) {
        if(head == null) return null;

        List<Tree> list = new ArrayList<>();
        Node currentNode = head;

        while (currentNode != null) {
            list.add(new Tree(currentNode.data));
            currentNode = currentNode.next;
        }

        for(int i = 0; i < list.size(); i++) {
            if(2 * i + 1 < list.size()) {
                list.get(i).left = list.get(2 * i + 1);
            }

            if(2 * i + 2 < list.size()) {
                list.get(i).right = list.get(2 * 1 + 2);
            }
        }

        return list.get(0);
    }
}

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}