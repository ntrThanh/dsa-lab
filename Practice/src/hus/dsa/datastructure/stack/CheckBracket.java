package hus.dsa.datastructure.stack;

public class CheckBracket {
    public static boolean check(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i) + "");
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                continue;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(check("((()1 - 2) + (2 - 4 * (4 + 3))))"));
    }
}
