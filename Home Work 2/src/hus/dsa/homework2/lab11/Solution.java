package hus.dsa.homework2.lab11;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        int n = getLength(head);
        ListNode currentNode = head;
        System.out.println(currentNode.val);
        System.out.println();

        ListNode temp = new ListNode();
        for (int i = 0; i < n; i++) {
            temp = new ListNode(currentNode.val, temp);
            currentNode = currentNode.next;
        }

        ListNode node = head;

        while (node != null) {
            if (node.val != temp.val) {
                return false;
            }

            node = node.next;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(0);

        //new Solution().print(head);
        new Solution().isPalindrome(head);
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length++;

            temp = temp.next;
        }

        return length;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

