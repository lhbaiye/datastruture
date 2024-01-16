package org.example.leetcode.bingchaji;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 17:08:41
 */

class DisJoinSet {
    private final int[] parent;
    private final int[] size;

    // 初始化并查集，根节点为自身，大小为1
    public DisJoinSet(int len) {
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void merge(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot]+=size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }
    }

    // 获取连通分量的大小
    public int getSize(int n) {
        int root = find(n);
        return size[root];
    }
}

public class leet803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int h = grid.length;
        int w = grid[0].length;
        int[] result = new int[hits.length];
        DisJoinSet disJoinSet = new DisJoinSet(h * w + 1);
        // 保存当前的砖块状态
        int[][] status = new int[h][w];
        for (int i = 0; i < h; i++) {
            status[i] = grid[i].clone();
        }
        for (int[] pos : hits) {
            status[pos[0]][pos[1]] = 0;
        }

        // 根据最后的状态构造并查集
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (status[i][j] == 0) {
                    continue;
                }
                if (i == 0) {
                    // 一块砖直接连接到网格的顶部
                    disJoinSet.merge( h * w, j);
                } else {
                    // 上方有相邻砖块
                    if (status[i - 1][j] == 1) {
                        disJoinSet.merge((i - 1) * w + j, i * w + j);
                    }
                    if (j > 0 && status[i][j - 1] == 1) {
                        disJoinSet.merge(i * w + j - 1, i * w + j);
                    }
                }
            }
        }
        // 从后向前把砖块补上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = hits.length - 1; i >= 0 ; i--) {
            int r = hits[i][0];
            int c = hits[i][1];
            if (grid[r][c] == 0) {
                result[i] = 0;
            } else {
                // 添加砖块前与房顶相连通的节点数目
                int prev = disJoinSet.getSize(h * w);
                // 顶部第一行的情况
                if (r == 0) {
                    disJoinSet.merge(c, h * w);
                }
                // 处理四周的节点
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (nr >= 0 && nr < h && nc >= 0 && nc < w && status[nr][nc] == 1) {
                        disJoinSet.merge(r * w + c, nr * w + nc);
                    }
                }
                // 获得增加的节点数，即为正向操作时这一步下落的节点数
                result[i] = Math.max(0, disJoinSet.getSize(h * w) - prev - 1);
                status[r][c] = 1;
            }
        }
        return result;
    }
}
