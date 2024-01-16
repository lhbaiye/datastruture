package org.example.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 邻阶矩阵
 * @date 2023/12/13 13:59:54
 */
public class GraphTest {

    class Grap {
        /**
         * 存放所有的顶点
         */
        public List<String> vertexs;
        /**
         * 矩阵：存放边的关系（顶点之间的关系）
         */
        private int[][] edges;
        /**
         * 存放多少条边
         */
        private int numOfEdges = 0;

        /**
         * @param n 有几个顶点
         */
        public Grap(int n) {
            vertexs = new ArrayList<>(n);
            edges = new int[n][n];
        }
        /**
         * 插入顶点
         *
         * @param vertex
         */
        public void insertVertex(String vertex) {
            vertexs.add(vertex);
        }
        /**
         * 添加边的关系
         *
         * @param v1     第一个顶点对应的矩阵下标
         * @param v2     第二个顶点对应的矩阵下标
         * @param weight 他们之间的关系：0|不直连，1|直连
         */
        public void insertEdge(int v1, int v2, int weight) {
            edges[v1][v2] = weight;
            // 由于是无向图，反向也可以连通
            edges[v2][v1] = weight;
            numOfEdges++;  // 边增加 1
        }

        public int getNumOfVertex() {
            return vertexs.size();
        }

        /**
         * 获取边的数量
         *
         * @return
         */
        public int getNumOfEdges() {
            return numOfEdges;
        }

        /**
         * 根据下标获得顶点的值
         *
         * @param i
         * @return
         */
        public String getValueByIndex(int i) {
            return vertexs.get(i);
        }

        /**
         * 显示图的矩阵
         */
        public void showGraph() {
            System.out.printf("  ");
            for (String vertex : vertexs) {
                System.out.printf(vertex + " ");
            }
            System.out.println();
            for (int i = 0; i < edges.length; i++) {
                System.out.printf(vertexs.get(i) + " ");
                for (int j = 0; j < edges.length; j++) {
                    System.out.printf(edges[i][j] + " ");
                }
                System.out.println();
            }
        }

        /**
         * 存放顶点是否已经访问过，下标对应顶点插入列表的下标
         */
        private boolean isVisiteds[];


        /**
         * 查找第一个邻接节点
         *
         * @param i
         * @return 如果找到，则返回具体的下标
         */
        public int getFirstNeighbor(int i) {
            for (int j = i; j < vertexs.size(); j++) {
                if (edges[i][j] == 1) {
                    return j;
                }
            }
            return -1;
        }

        /**
         * 如果 w 节点被访问过，则查找 i 节点的下一个 邻接节点（就不是第一个节点了）
         *
         * @param i
         * @param w
         * @return
         */
        private int getNextNeighbor(int i, int w) {
            for (int j = w + 1; j < vertexs.size(); j++) {
                if (edges[i][j] == 1) {
                    return j;
                }
            }
            return -1;
        }

        public void dfs() {
            for (int i = 0; i < vertexs.size(); i++) {
                if (isVisiteds[i]) {
                    continue;
                }
                dfs(i);
            }
        }
        public void dfs(int i) {
            System.out.print(vertexs.get(i) + " -> ");
            isVisiteds[i] = true;
            int w = getFirstNeighbor(i);
            while (w != -1) {
                if (isVisiteds[w]) {
                    w = getNextNeighbor(i, w);
                } else {
                    dfs(w);
                }
            }
        }

        public void bsf() {
            for (int i = 0; i < vertexs.size(); i++) {
                if (isVisiteds[i]) {
                    continue;
                }
                System.out.println("新的节点广度优先");
                bsf(i);
            }
        }
        /**
         * 对单个节点为初始节点，进行广度优先遍历
         *
         * @param i
         */
        private void bsf(int i) {
            // 访问该节点，并标记已经访问
            System.out.print(getValueByIndex(i) + " → ");
            isVisiteds[i] = true;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(i);
            int u; // 队列头的节点
            int w; // u 的下一个邻接节点
            while (!queue.isEmpty()) {
                u = queue.removeFirst();
                w = getFirstNeighbor(u);
                while (w != -1) {
                    if (!isVisiteds[w]) {
                        System.out.print(getValueByIndex(w) + " → ");
                        isVisiteds[w] = true;
                        queue.addLast(w); // 访问过的一定要入队列
                    }
                    w = getNextNeighbor(u, w);
                }
            }
        }

    }
}
