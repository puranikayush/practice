package org.lfucache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    private final Map<String, Node> cacheMap;
    private final Map<Integer, ListAttribute> freqMap;
    private int minFreq;
    int size = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void put(String key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            removeNode(node);
            node.freq++;
            ListAttribute listAttribute = freqMap.getOrDefault(node.freq, emptyList());
            addToFirst(listAttribute.head, node);
            freqMap.put(node.freq, listAttribute);
            return;
        }
        if (size == capacity) {
            ListAttribute listAttribute = freqMap.get(minFreq);
            Node node = listAttribute.tail.prev;
            removeNode(node);
            if (listAttribute.head.next == listAttribute.tail) {
                freqMap.remove(minFreq);
                if(minFreq == node.freq)
                    minFreq++;
            }
            cacheMap.remove(node.key);
            size--;
        }
        ListAttribute listAttribute = freqMap.getOrDefault(1, emptyList());
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.freq = 1;
        addToFirst(listAttribute.head, node);
        cacheMap.put(key, node);
        freqMap.put(1, listAttribute);
        minFreq = 1;
        size++;


    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    public int get(String key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            removeNode(node);
            int oldFreq = node.freq;
            ListAttribute oldList = freqMap.get(oldFreq);

            node.freq++;
            ListAttribute listAttribute = freqMap.getOrDefault(node.freq, emptyList());
            addToFirst(listAttribute.head, node);
            freqMap.put(node.freq, listAttribute);
            if (oldList.head.next == oldList.tail) {
                freqMap.remove(oldFreq);
                if(minFreq == oldFreq)
                    minFreq++;
            }
            System.out.printf("key %s, val %s, freq %s\n--\n", node.key, node.value, node.freq);
            return node.value;
        }
        return -1;
    }

    private void addToFirst(Node head, Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    private ListAttribute emptyList() {
        Node head = new Node();
        Node tail = new Node();
        head.next = tail;
        tail.prev = head;
        return new ListAttribute(head, tail);
    }


    public static class Node {
        String key;
        int value;
        Node next;
        Node prev;
        int freq;
    }

    public static class ListAttribute {
        Node head;
        Node tail;

        public ListAttribute(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
