package com.luddwg.support;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Store {

    private final HashMap<Long, List<File>> map = new HashMap<>();

    public void add(long key, File value) {
        map.computeIfAbsent(key, k -> new ArrayList<>());
        map.get(key).add(value);
    }

    public Set<Long> getKeySet() {
        return map.keySet();
    }

    public List<File> get(long key) {
        return map.get(key);
    }
}
