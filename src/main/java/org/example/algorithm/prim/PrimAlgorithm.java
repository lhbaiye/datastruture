package org.example.algorithm.prim;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 普利姆算法
 * @date 2023/12/13 21:48:30
 */
public class PrimAlgorithm {
    class MGraph {
        int vertex;  // 顶点个数
        int[][] weights;  // 邻接矩阵
        char[] datas; // 村庄数据

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
        }

        public void show() {
            System.out.printf("%-8s"," ");
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

    class MinTree {
        /**
         * 普利姆算法
         *
         * @param mGraph 无向图
         * @param v      从哪一个点开始生成
         */
        public void prim(MGraph mGraph, int v) {
            int minTotalWeight = 0; // 记录已选择的边的总权值，仅仅只是为了测试打印验证
            boolean[] selects = new boolean[mGraph.vertex];
            selects[v] = true;
            // 一共生成 N-1条边
            for (int i = 1; i < mGraph.vertex; i++) {
                // 每次循环 选出一条权值最小的边
                int minWeight = 10000;
                int x = -1;
                int y = -1;
                // 每次查找权值最小的边：根据思路，每次都是从已经选择过的点，中去找与该点直连的点的权值
                // 并且该点还没有被选择过：如果两个点都被选择过，要么他们是双向的，要么就是被其他的点选择过了
                // 这里双循环的含义：建议对照笔记中步骤分析理解
                for (int j = 0; j < mGraph.vertex; j++) {
                    for (int k = 0; k < mGraph.vertex; k++) {
                        if (selects[j] && !selects[k] && mGraph.weights[j][k] < minWeight) {
                            // 记录最小权值，与这条边的信息
                            minWeight = mGraph.weights[j][k];
                            x = j;
                            y = k;
                        }
                    }
                }
                // 当一次循环结束时：就找到了一条权值最小的边
                System.out.printf("%s,%s [%s] \n", mGraph.datas[x], mGraph.datas[y], mGraph.weights[x][y]);
                minTotalWeight += mGraph.weights[x][y]; // 统计已选择边权值
                // 记录该点已经被选择
                // 在查找最小权值边的代码中：y=k, k 表示没有被选择过的点，所以，找到之后，这里记录 y 为这条边的另一个点
                selects[y] = true;
            }
        }
    }
}
