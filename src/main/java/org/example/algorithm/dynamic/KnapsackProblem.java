package org.example.algorithm.dynamic;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 动态规划
 * @date 2023/12/13 16:29:54
 */
public class KnapsackProblem {

    /**
     * 填表法：输出填表后的信息
     */
    @Test
    public void table() {
        // 商品价值和重量前面都有一个 0 ，方便后续的公式写法
        int[] val = {0, 1500, 3000, 2000};  // 商品价值
        int[] w = {0, 1, 4, 3}; // 商品对应重量
        int m = 4;
        int n = val.length;
        // 构建初始表格， +1 是因为有一行列和行都是 0
        // v[i][j] 存放的是：前 i 个物品中能够装入容量为 j 的背包中的最大价值
        int[][] v = new int[n][m + 1];
        // 1. 初始化  v[i][0] = v[0][j]=0
        //    本程序中，可以不初始化，默认就是 0
        //    为了体现步骤，进行初始化（有可能在你的场景中有其他的含义）
        // 为了与默认值 0 区分开，看出初始化效果，这里默 0 定义为 -1
        // 验证之后，修改回 0，否则在计算上一个格子的时候，就会导致计算错误
        int zero = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                v[i][0] = zero; // 初始化第一列为 0
                v[0][i] = zero; // 初始化第一行为 0
            }
        }
        // 用于存放每个格子中保存的商品
        int[][] path = new int[n][m + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                // 当当前物品重量大于，背包限定重量时：
                //   当前背包容量，可存放最大的商品价值为：前一格子中的存放策略总价值
                if (w[i] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    int pre = v[i - 1][j]; // 前一个格子中存放策略总价值
                    int curr = val[i]; // i当前商品总价值
                    int free = v[i - 1][j - w[i]];  // 存放完当前商品后，剩余空间能存放的总价值
                    // 当需要存放新的策略时，标记当前路径
                    if (pre < curr + free) {
                        v[i][j] = curr + free;
                        path[i][j] = 1;
                    } else {
                        v[i][j] = pre;
                    }
                }
            }
        }
    }
}
