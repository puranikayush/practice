package org.lfucache;

public class LFUMain {
    public static void main(String[] args) {
        System.out.println("LFU Cache Test");

        LFUCache cache = new LFUCache(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        //cache.printCache();

        System.out.println("get a: " + cache.get("a")); // freq(a)=2
        System.out.println("get b: " + cache.get("b")); // freq(b)=2
        //cache.printCache();

        // This should evict "c" (freq=1)
        cache.put("d", 4);
        //cache.printCache();

        System.out.println("get d: " + cache.get("d")); // freq(d)=2
        System.out.println("get a: " + cache.get("a")); // freq(a)=3
        //cache.printCache();

        // This should evict "b" (freq=2 but LRU among freq=2)
        cache.put("e", 5);

        System.out.println("LFU Cache Test Ends");
        //cache.printCache();
    }
}