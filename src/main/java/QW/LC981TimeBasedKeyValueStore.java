package QW;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC981TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> map;
    public LC981TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> cur = map.getOrDefault(key, new TreeMap<>());
        cur.put(timestamp, value);
        map.put(key, cur);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> cur = map.get(key);
        if(cur == null) return "";
        Integer flKey = cur.floorKey(timestamp);
        if(flKey == null) return "";
        return cur.get(flKey);
    }
}
