package hus.dsa.datastructure.finalpractice.backtracking;

public class PrefixTree {
    class Node {
        boolean isEnd;
        Node[] nodes;

        public Node() {
            nodes = new Node[26];
        }

        public void insert(String word, int position) {
            if (position >= word.length()) {
                return;
            }

            int index = word.charAt(position) - 'a';
            if (nodes[index] == null) {
                nodes[index] = new Node();
            }

            if (index == word.length() - 1) {
                nodes[index].isEnd = true;
            }

            insert(word, position + 1);
        }

        public boolean search(String word, int position) {
            if (position >= word.length()) {
                return false;
            }

            Node node = nodes[word.charAt(position) - 'a'];
            if (node == null) {
                return false;
            }

            if (position == word.length() - 1 && node.isEnd) {
                return true;
            }

            return search(word, position + 1);
        }

        public boolean startWith(String word, int position) {
            if (position >= word.length()) {
                return false;
            }

            Node node = nodes[word.charAt(position) - 'a'];
            if (node == null) {
                return false;
            }

            if (position == word.length() - 1) {
                return true;
            }

            return search(word, position + 1);
        }
    }
    Node node;

    public void insert(String word) {
        node.insert(word, 0);
    }

    public boolean search(String word) {
        return node.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return node.startWith(prefix, 0);
    }
}
