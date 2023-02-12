package org.lllbllllb.problems.timebasedkeyvaluestore;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/time-based-key-value-store/">981. Time Based Key-Value Store</a>
 */
// 153 ms, 117.1 MB
class TimeMap {

    private final Map<String, List<AbstractMap.SimpleEntry<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        var linkedMap = map.computeIfAbsent(key, k -> new ArrayList<>());
        var entry = new AbstractMap.SimpleEntry<>(timestamp, value);
        linkedMap.add(entry);
    }

    public String get(String key, int timestamp) {
        var values = map.get(key);

        if (values == null) {
            return "";
        }

        var from = 0;
        var to = values.size() - 1;
        var tmp = "";

        while (from <= to) {
            var idx = (from + to) / 2;
            var entry = values.get(idx);

            if (entry.getKey() > timestamp) {
                to = idx - 1;
            } else if (entry.getKey() < timestamp) {
                from = idx + 1;
                tmp = entry.getValue();
            } else {
                return entry.getValue();
            }
        }

        return tmp;
    }
}

// 156 ms, 117.5 MB
class TimeMap1 {

    private final Map<String, TreeMap<Integer, String>> map;

    public TimeMap1() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        var linkedMap = map.computeIfAbsent(key, k -> new TreeMap<>());
        linkedMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        var linkedMap = map.get(key);

        if (linkedMap == null) {
            return "";
        }

        var valueEntry = linkedMap.floorEntry(timestamp);

        if (valueEntry != null) {
            return valueEntry.getValue();
        }

        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
