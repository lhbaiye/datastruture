package org.example.leetcode.bingchaji;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 16:52:40
 */
public class leet684 {

    private int[] parent;
    private int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        size = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] arr : edges) {
            if (union(arr[0], arr[1])) {
                return arr;
            }
        }
        return new int[]{};
    }

    private boolean union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return true;
        }
        // Weighted Quick Union
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        return false;
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
