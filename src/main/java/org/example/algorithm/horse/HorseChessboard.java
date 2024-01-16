package org.example.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 骑士周游问题-马踏棋盘
 * @date 2023/12/14 17:03:44
 */
public class HorseChessboard {

    int X = 8; // 棋盘的行数
    int Y = 8; // 棋盘的列数

    /**
     * 根据马儿所在的位置，查找它下一步可以走的位置
     *
     * @param current
     * @return
     */
    public ArrayList<Point> next(Point current) {
        ArrayList<Point> result = new ArrayList<>();
        int cx = current.x;
        int cy = current.y;
        // 第 0 个点
        if (cx - 1 >= 0 && cy + 2 < Y) {
            result.add(new Point(cx - 1, cy + 2));
        }
        // 第 1 个点
        if (cx + 1 < X && cy + 2 < Y) {
            result.add(new Point(cx + 1, cy + 2));
        }
        // 第 2 个点
        if (cx + 2 < X && cy - 1 >= 0) {
            result.add(new Point(cx + 2, cy - 1));
        }
        // 第 3 个点
        if (cx + 2 < X && cy + 1 < Y) {
            result.add(new Point(cx + 2, cy + 1));
        }
        // 第 4 个点
        if (cx + 1 < X && cy - 2 >= 0) {
            result.add(new Point(cx + 1, cy - 2));
        }
        // 第 5 个点
        if (cx - 1 >= 0 && cy - 2 >= 0) {
            result.add(new Point(cx - 1, cy - 2));
        }
        // 第 6 个点
        if (cx - 2 >= 0 && cy - 1 >= 0) {
            result.add(new Point(cx - 2, cy - 1));
        }
        // 第 7 个点
        if (cx - 2 >= 0 && cy + 1 < Y) {
            result.add(new Point(cx - 2, cy + 1));
        }
        return result;
    }

    private boolean finished; // 是否已经完成，由于是递归，在某一部已经完成，回溯可以跳过
    private boolean[] visited = new boolean[X * Y]; // 标记是否访问过，访问过的不再访问
    /**
     * 马踏棋盘算法核心代码
     *
     * @param chessboard 棋盘，用于标识哪一个点是第几步走的
     * @param cx         当前要尝试访问的点 x 坐标（行）
     * @param cy         当前要尝试访问的点 y 坐标（列）
     * @param step       当前是第几步
     */
//    public void traversalChessboard(int[][] chessboard, int cx, int cy, int step) {
//        // 1. 标识当前点已经访问
//        visited[buildVisitedIndex(cx, cy)] = true;
//        // 2. 标识当前棋盘上的点是第几步走的
//        chessboard[cx][cy] = step;
//        // 根据当前节点计算马儿可以走的
//        ArrayList<Point> points = next(new Point(cx, cy));
//        while (!points.isEmpty()) {
//            Point point = points.remove(0);
//            if (!visited[buildVisitedIndex(point.x, point.y)]) {
//                traversalChessboard(chessboard, point.x, point.y, step + 1);
//            }
//        }
//        // 所有可走的点都走完了，如果还没有完成，则重置当前访问的点为没有访问过
//        if (step < X * Y && !finished) {
//            visited[buildVisitedIndex(cx, cy)] = false;
//            chessboard[cx][cy] = 0; // 重置为 0 表示没有走过
//        } else {
//            finished = true;
//        }
//
//    }

    public void traversalChessboard(int[][] chessboard, int cx, int cy, int step) {
        //标识该点走过了
        visited[buildVisitedIndex(cx, cy)] = true;
        chessboard[cx][cy] = step;
        ArrayList<Point> points = next(new Point(cx, cy));
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visited[buildVisitedIndex(point.x, point.y)]) {
                traversalChessboard(chessboard, point.x, point.y, step + 1);
            }
        }
        // 这个点所有可走的走完了
        if (step < X * Y && !finished) {
            visited[buildVisitedIndex(cx, cy)] = false;
            chessboard[cx][cy] = 0; // 重置为 0 表示没有走过
        } else {
            finished = true;
        }
    }

    private void sort(ArrayList<Point> points) {
        points.sort(((o1, o2) -> {
            ArrayList<Point> next1 = next(o1);
            ArrayList<Point> next2 = next(o2);
            if (next1.size() > next2.size()) {
                return 1;
            } else if (next1.size() == next2.size()) {
                return 0;
            } else {
                return -1;
            }
        }));
    }


    /**
     * 使用的是一个一维数组来表示某个点是否被访问过
     * <pre>
     *   那么就直接数格子，第 N 个格子对应某一个点，从左到右，上到下数
     *   0,1,2,3,4,5,6,7,
     *   8,9,10,11...
     * </pre>
     *
     * @param cx
     * @param xy
     * @return
     */
    private int buildVisitedIndex(int cx, int xy) {
        //比如 0,1: 0*8 + 1 =  1
        return cx * X + xy;
    }

}
