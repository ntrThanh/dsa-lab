package hus.dsa.homework4.practice.lab10;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue = new ArrayDeque<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        queue.add(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}