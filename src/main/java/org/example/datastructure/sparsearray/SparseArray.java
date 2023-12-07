package org.example.datastructure.sparsearray;

/**
 * @author 15206
 * @description 二维数组和稀疏矩阵的转换
 */
public class SparseArray {
    public static void main(String[] args) {

    }

    /**
     * 打印棋盘上的棋子布局
     *
     * @param chessArr
     */
    public static void printChessArray(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                // 左对齐，使用两个空格补齐 2 位数
                System.out.printf("%-2d\t", data);
            }
            System.out.println("");
        }
    }


    /**
     * 二维数组转稀疏矩阵
     */
    private static int[][] chessToSparse(int[][] chessArr) {
        // 遍历得到非0的数字
        int sum = 0;
        for(int[] row : chessArr) {
            for(int data : row) {
                if(data != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 3. 给稀疏数组赋值
        int chessRow = chessArr.length;
        int chessCol = 0;
        int count = 0; // 记录当前是第几个非 0 的数据
        for (int i = 0; i < chessArr.length; i++) {
            int[] rows = chessArr[i];
            if (chessCol == 0) {
                chessCol = rows.length;
            }
            for (int j = 0; j < rows.length; j++) {
                int chess = rows[j];
                if (chess == 0) {
                    continue;
                }
                count++;  // 第一行是棋盘信息，所以先自增
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chess;
            }
        }
        // 4. 补全第一行的棋盘大小和有效数据
        sparseArr[0][0] = chessRow;
        sparseArr[0][1] = chessCol;
        sparseArr[0][2] = sum;
        return sparseArr;
    }

    /**
     ** 稀疏数组转二维数组
     ** @param sparseArr
     * @return
     */
    private static int[][] sparseToChess(int[][] sparseArr) {
        // 1. 创建二维数组
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. 恢复有效数据到二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            int[] rows = sparseArr[i];
            chessArr[rows[0]][rows[1]] = rows[2];
        }
        return chessArr;
    }
}
