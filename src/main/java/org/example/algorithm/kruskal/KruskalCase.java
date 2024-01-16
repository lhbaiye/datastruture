package org.example.algorithm.kruskal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 克鲁斯卡尔
 * @date 2023/12/13 23:22:32
 */
public class KruskalCase {
    // 不连通的默认值：0 则代表同一个点
    int INF = 100000;

    class MGraph {
        int vertex; // 顶点个数
        int[][] weights;
        char[] datas;
        int edgeNum; // 共有多少变
        public MGraph(int vertex, int[][] weights) {
            this.vertex = vertex;
            this.weights = weights;
            this.datas = new char[vertex];
            for (int i = 0; i < vertex; i++) {
                datas[i] = (char) (65 + i);
            }
            // 计算有多少条边
            for (int i = 0; i < weights.length; i++) {
                for (int j = i + 1; j < weights.length; j++) {
                    if (weights[i][j] != INF) {
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

    public Edata[] covertEdatas(MGraph graph) {
        Edata[] data = new Edata[graph.edgeNum];
        int[][] weights = graph.weights;
        char[] vertex = graph.datas;
        int index = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i][j] != INF) {
                    data[index++] = new Edata(vertex[i], vertex[j], weights[i][j]);
                }
            }
        }
        return data;
    }

    /**
     * 将边按权值从小到大排序
     *
     * @param edata
     */
    public void sort(Edata[] edata) {
        Arrays.sort(edata, Comparator.comparingInt(o -> o.weight));
    }

    public Edata[] kruskal(MGraph mGraph, Edata[] edatas) {
        // 存放结果，数组最大容量为所有边的容量
        Edata[] rets = new Edata[mGraph.edgeNum];
        int retsIndex = 0;
        /*
          按照算法思路：
            记录顶点在 **最小生成树** 中的终点，顶点的终点是 **在最小生成树中与它连通的最大顶点**。
            然后每次需要将一条边添加到最小生存树时，判断该边的两个顶点的终点是否重合，重合的话则会构成回路。
         */
        // 用于存所有的终点：该数组中的内容随着被选择的边增加，终点也会不断的增加
        int[] ends = new int[mGraph.edgeNum];
        // 对所有边进行遍历
        for (Edata edata : edatas) {
            // 获取这两条边的顶点下标:
            //  第一次：E,F  ->  4,5
            int p1 = getPosition(mGraph.datas, edata.start);
            int p2 = getPosition(mGraph.datas, edata.end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                rets[retsIndex++] = edata;
            }
        }
        return rets;
    }


    private int getPosition(char[] vertexs, char vertex) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == vertex) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 获取该顶点的：终点
     *
     * @param ends
     * @param vertexIndex
     * @return
     */
    private int getEnd(int[] ends, int vertexIndex) {
        int temp = vertexIndex;
        while (ends[temp] != 0) {
            temp = ends[temp];
        }
        return temp;
    }

    class Edata {
        char start;
        char end;
        int weight;
        public Edata(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return start + "," + end + " [" + weight + "]";
        }
    }
}
