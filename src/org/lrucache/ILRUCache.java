package org.lrucache;

public interface ILRUCache {
    int get(String key);

    void put(String key, int value);
}
