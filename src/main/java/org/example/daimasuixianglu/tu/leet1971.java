package org.example.daimasuixianglu.tu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 17:05:02
 */
public class leet1971 {
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        init();
        //添加
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
        }
        return isSame(source, destination);
    }

    // 判断是否相同
    private boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    // 并查集里寻根的过程
    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    // 加入节点
    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    // 并查集初始化
    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }
}
