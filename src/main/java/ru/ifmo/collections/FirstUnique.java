package ru.ifmo.collections;

import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;

public class FirstUnique {
    private final Map<Integer, Integer> map;
    private final Queue<Integer> queue;

    public FirstUnique(int[] numbers) {
        queue = new ArrayDeque<>();
        map = new HashMap<>();
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.element()) > 1) {
            queue.remove();
        }
        return (queue.isEmpty() ? -1 : queue.element());
    }

    public void add(int value) {
        queue.add(value);
        map.merge(value, 1, Integer::sum);
    }
}
