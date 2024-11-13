package hus.dsa.datastructure.finalpractice.collections.list;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();

        list.add(12);
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(5);
        list.add(7);
        list.add(5);
        list.add(-1);
        list.add(20);

        list.add(-100, 0);
        list.delete(list.size() - 1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
