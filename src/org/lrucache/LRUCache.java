package org.lrucache;

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
            removeNode(cacheNode);
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
            removeNode(cacheNode);
            addToFront(cacheNode);
        } else {
            if (size == capacity) {
                CacheNode prev = tail.prev;
                removeNode(prev);
                deleteCacheKey(prev.key);
                size--;
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
        System.out.println("Size : "+size);
        CacheNode temp = head.next;
        while(temp!=tail){
            System.out.printf("(%s,%s)->", temp.key, temp.value);
            temp=temp.next;
        }
        System.out.println();
    }


    private void removeNode(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void deleteCacheKey(String key){
        cacheMap.remove(key);
    }

    private void addToFront(CacheNode node) {
        CacheNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
//        cacheMap.put(node.key,node);
    }

    private class CacheNode {
        private String key;
        private int value;
        private CacheNode prev;
        private CacheNode next;
    }

}
