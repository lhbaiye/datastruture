package org.example.daimasuixianglu.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @date 2024/1/16 15:42:09
 */
public class leet96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
