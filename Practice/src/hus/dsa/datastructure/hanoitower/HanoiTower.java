package hus.dsa.datastructure.hanoitower;

public class HanoiTower {
    public static void change(int number, char a, char b, char c) {
        if (number == 1) {
            System.out.println(a + " -> " + c);
        } else {
            change(number - 1, a, c, b);
            change(1, a, b, c);
            change(number - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        change(3, 'a', 'b', 'c');
    }
}
