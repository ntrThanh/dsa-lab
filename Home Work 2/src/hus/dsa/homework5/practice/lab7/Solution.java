package hus.dsa.homework5.practice.lab7;

import hus.dsa.homework5.practice.Node;

public class Solution
{
    int minDepth(Node root)
    {
        //code here
        if (root == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

