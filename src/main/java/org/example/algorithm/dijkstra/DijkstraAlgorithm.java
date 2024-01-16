package org.example.algorithm.dijkstra;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 迪杰斯特拉算法-最短路径问题
 * @date 2023/12/14 15:26:34
 */
public class DijkstraAlgorithm {
    int N = 100000;
    class MGraph {
        int vertex;
        int[][] weights;
        char[] datas;
        int edgeNum;
        /**
         * @param vertex  村庄数量， 会按照数量，按顺序生成村庄，如 A、B、C...
         * @param weights 需要你自己定义好那些点是连通的，那些不是连通的
         */
        public MGraph(int vertex, int[][] weights) {
            this.vertex = vertex;
            this.weights = weights;

            this.datas = new char[vertex];
            for (int i = 0; i < vertex; i++) {
                // 大写字母 A 从 65 开始
                datas[i] = (char) (65 + i);
            }
            // 计算有多少条边
            for (int i = 0; i < weights.length; i++) {
                /*
                        A       B       C       D       E       F       G
                A       0       12      100000  100000  100000  16      14
                B       12      0       10      100000  100000  7       100000
                j = i + 1：比如:
                        i=0,j=1, 那么就是 A,B 从而跳过了 A,A
                        i=1,j=2, 那么就是 B,C 从而跳过了 B,A  B,B
                        那么含义就出来了：跳过双向边的统计，也跳过自己对自己值得为 0 的统计
                 */
                for (int j = i + 1; j < weights.length; j++) {
                    if (weights[i][j] != N) {
                        edgeNum++;
                    }
                }
            }
        }
        public void show() {
            System.out.printf("%-8s", " ");
            for (char vertex : datas) {
                // 控制字符串输出长度：少于 8 位的，右侧用空格补位
                System.out.printf("%-8s", vertex + " ");
            }
            System.out.println();
            for (int i = 0; i < weights.length; i++) {
                System.out.printf("%-8s", datas[i] + " ");
                for (int j = 0; j < weights.length; j++) {
                    System.out.printf("%-8s", weights[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    @Test
    public void dijkstraTest() {
        int[][] weights = new int[][]{
                //     A  B  C  D  E  F  G
                /*A*/ {N, 5, 7, N, N, N, 2},
                /*B*/ {5, N, N, 9, N, N, 3},
                /*C*/ {7, N, N, N, 8, N, N},
                /*D*/ {N, 9, N, N, N, 4, N},
                /*E*/ {N, N, 8, N, N, 5, 4},
                /*F*/ {N, N, N, 4, 5, N, 6},
                /*G*/ {2, 3, N, N, 4, 6, N}
        };
        MGraph mGraph = new MGraph(7, weights);
        mGraph.show();
        System.out.printf("共有 %d 条边 \n", mGraph.edgeNum);

        dijkstra(mGraph, 'G');
    }

    // 记录各个顶点是否访问过
    private boolean[] alreadyArr;
    // 记录每个下标对应的值为前一个顶点下标
    private int[] preVisitedArr;
    // 记录出发点到其他所有顶点的距离
    private int[] disArr;

    private MGraph mGraph;

    private void dijkstra(MGraph mGraph, char start) {
        this.mGraph = mGraph;
        // 舍宁三个数组
        this.alreadyArr = new boolean[mGraph.vertex];
        this.preVisitedArr = new int[mGraph.vertex];
        this.disArr = new int[mGraph.vertex];

        // 找到该起始点的下标
        int v = 0;
        for (int i = 0; i < mGraph.datas.length; i++) {
            if (mGraph.datas[i] == start) {
                v = i;
                break;
            }
        }

        // 初始化
        Arrays.fill(preVisitedArr, N);
        Arrays.fill(disArr, N);
        alreadyArr[v] = true;
        disArr[v] = 0;

        // 开始工作，修改disArr找到最短路劲
        update(v);
        for (int data : mGraph.datas) {
            int index = findNext(v);
            alreadyArr[index] = true;
            update(index);
        }

    }

    private int findNext(int v) {
        int min = N, index = 0;
        for (int i = 0; i < alreadyArr.length; i++) {
            if (!alreadyArr[i] && disArr[i] < min) {
                min = disArr[i];
                index = i;
            }
        }
        return index;
    }

    public void update(int v) {
        int[][] weights = mGraph.weights;
        int len = 0;
        for (int i = 0; i < weights[v].length; i++) {
            if (weights[v][i] == N) {
                continue;
            }
            len = disArr[v] + weights[v][i];
            // 首先：起点G -> A, A 要没有被访问过
            // 其次：如果当前计算新的路径距离 小于 已经存在的 从 起点 G -> 当前计算点的距离
            //      说明之前可能从其他途径到达了 i 点，这个距离是比现在找到的距离远
            // 当前的近，那么就更新数组中的数据
            if (!alreadyArr[i] && len < disArr[i]) {
                disArr[i] = len;
                preVisitedArr[i] = v; // 更改前驱节点，表示 经过了 v 这个点（当前正在访问的点），到达的 i 点
            }
        }
    }
}
