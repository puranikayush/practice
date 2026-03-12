package org.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements ILRUCache {

    private final int capacity;
    private int size;
    private Map<String, CacheNode> cacheMap;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity_) {
        this.capacity = capacity_;
        size = 0;
        cacheMap = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public int get(String key) {
        if (cacheMap.containsKey(key)) {
            CacheNode cacheNode = cacheMap.get(key);
            evict(cacheNode);
            addToFront(cacheNode);
            return cacheNode.value;
        }
        return -1;
    }

    @Override
    public void put(String key_, int value_) {
        if (cacheMap.containsKey(key_)) {
            CacheNode cacheNode = cacheMap.get(key_);
            cacheNode.value = value_;
            addToFront(cacheNode);
        } else {
            if (size == capacity) {
                evict(tail.prev);
            }
            CacheNode node = new CacheNode();
            node.key = key_;
            node.value = value_;
            addToFront(node);
            cacheMap.put(key_, node);
            size++;
        }
        printCache();
    }

    public void printCache() {
        CacheNode temp = head.next;
        while(null!=temp){
            System.out.printf("(%s,%s)->", temp.key, temp.value);
            temp=temp.next;
        }
        System.out.println();
    }


    private void evict(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
        cacheMap.remove(node.key);
    }

    private void addToFront(CacheNode node) {
        CacheNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private class CacheNode {
        private String key;
        private int value;
        private CacheNode prev;
        private CacheNode next;
    }

}
