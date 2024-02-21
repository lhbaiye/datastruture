package org.example.daimasuixianglu.tu;

import java.util.ArrayList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 17:29:23
 */
public class leet685 {
    private static final int n = 1010;
    private int[] father = new int[n];

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[n];
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]] += 1;
        }
        // 找入度为2的节点所对应的边，注意要倒序，因为优先返回最后出现在二维数组中的答案
        ArrayList<Integer> twoDegree = new ArrayList<Integer>();
        for (int i = edges.length - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                twoDegree.add(i);
            }
        }
        // 处理图中情况1 和 情况2
        // 如果有入度为2的节点，那么一定是两条边里删一个，看删哪个可以构成树
        if (!twoDegree.isEmpty()) {
            if(isTreeAfterRemoveEdge(edges, twoDegree.get(0))) {
                return edges[twoDegree.get(0)];
            }
            return edges[twoDegree.get(1)];
        }
        // 明确没有入度为2的情况，那么一定有有向环，找到构成环的边返回就可以了
        return getRemoveEdge(edges);
    }

    private int[] getRemoveEdge(int[][] edges) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            }
            join(edges[i][0], edges[i][1]);
        }
        return new int[0];
    }

    private boolean isTreeAfterRemoveEdge(int[][] edges, Integer deleteEdge) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) {
                continue;
            }
            if (isSame(edges[i][0], edges[i][1])) {
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    // 初始化
    public void init() {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    //寻根
    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
            return father[u];
        }
    }
    //判断是否相同的根节点
    public boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }
}
