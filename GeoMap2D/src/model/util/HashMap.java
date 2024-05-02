package model.util;

public class HashMap<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public HashMap() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private void resize() {
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int index = (hash(entry.key) & (newCapacity - 1));
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;
            }
        }
        table = newTable;
    }

    public void put(K key, V value) {
        int index = hash(key) & (table.length - 1);
        Entry<K, V> entry = table[index];
        for (Entry<K, V> e = entry; e != null; e = e.next) {
            if (equals(e.key, key)) {
                e.value = value;
                return;
            }
        }
        if (size >= table.length * LOAD_FACTOR) {
            resize();
            index = hash(key) & (table.length - 1);
        }
        table[index] = new Entry<>(key, value, table[index]);
        size++;
    }

    public V get(K key) {
        int index = hash(key) & (table.length - 1);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (equals(entry.key, key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key) & (table.length - 1);
        Entry<K, V> prev = null;
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (equals(entry.key, key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return true;
            }
            prev = entry;
            entry = entry.next;
        }
        return false;
    }

    private boolean equals(K key1, K key2) {
        if (key1 == key2) {
            return true;
        }
        if (key1 == null || key2 == null) {
            return false;
        }
        return key1.equals(key2);
    }

    public int size() {
        return size;
    }
}
