package org.example.daimasuixianglu.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 15:54:38
 */
public class leet841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<Boolean>(){{
            for(int i = 0 ; i < rooms.size(); i++){
                add(false);
            }
        }};
        dfs(rooms, 0, visited);
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int key, List<Boolean> visited) {
        if (visited.get(key)) {
            return;
        }
        visited.set(key, true);
        for (int k : rooms.get(key)) {
            dfs(rooms, k, visited);
        }
    }
}
