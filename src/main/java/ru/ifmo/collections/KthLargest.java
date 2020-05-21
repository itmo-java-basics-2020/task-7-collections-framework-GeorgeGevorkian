package ru.ifmo.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    private final Queue<Integer> min_heap;

    public KthLargest(int k, int[] numbers) {
        min_heap = new PriorityQueue<>();
        for (int number : numbers) {
            min_heap.add(number);
        }

        while (min_heap.size() != k) {
            min_heap.remove();
        }
    }

    public int add(int val) {
        if (val > min_heap.element()) {
            min_heap.remove();
            min_heap.add(val);
        }
        return min_heap.element();
    }
}