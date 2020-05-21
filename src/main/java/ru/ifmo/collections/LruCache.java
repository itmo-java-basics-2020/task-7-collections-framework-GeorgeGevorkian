package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    private LinkedHashMap<K, V> map;

    public LruCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, (float) 0.75, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public int elements() {
        return map.size();
    }
}