package org.example.daimasuixianglu.huisu;

import java.util.*;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/11 12:57:22
 */
public class leet332 {
    private LinkedList<String> res;
    private Map<String, Map<String, Integer>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int size) {
        if (res.size() == size + 1) {
            return true;
        }
        String last = res.getLast();
        if (map.containsKey(last)) {
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(size)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

}
