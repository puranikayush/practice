package org;

import org.cache.LRUCache;

public class LRUMain {
    static void main() {
        System.out.println("First Project");
        LRUCache cache = new LRUCache(5);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);
        System.out.println(cache.get("a"));
        cache.printCache();

        System.out.println(cache.get("c"));
        cache.printCache();

        cache.put("f",6);
    }
}
