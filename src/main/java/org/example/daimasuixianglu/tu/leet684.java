package org.example.daimasuixianglu.tu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 17:10:22
 */
public class leet684 {
    private int n = 1005;  // 节点数量3 到 1000
    private int[] father = new int[n];
    public int[] findRedundantConnection(int[][] edges) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    public void init() {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    public boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return ;
        }
        father[v] = u;
    }
}
