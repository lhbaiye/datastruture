package org.example.daimasuixianglu.tanxin;

import org.example.daimasuixianglu.erchashu.TreeNode;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 19:44:32
 */
public class leet968 {
    int  res=0;
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[0], res[2]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0}; // 除 2 防止加法溢出
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int choose = Math.min(left[0], left[1]) + Math.min(right[0], right[1]) + 1;
        int byFather = Math.min(left[0], left[2]) + Math.min(right[0], right[2]);
        int byStudent = Math.min(Math.min(left[0] + right[2], left[2] + right[0]), left[0] + right[0]);
        return new int[]{choose, byFather, byStudent};
    }

    /**
     节点的状态值：
     0 表示无覆盖
     1 表示 有摄像头
     2 表示有覆盖
     后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    private int minCame(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if (left == 2 && right == 2) {
            return 0;
        }
        // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
        // (0,0) (0,1) (0,2) (1,0) (2,0)
        // 状态值为 1 摄像头数 ++;
        if(left==0||right==0) {
            res++;
            return 1;
        }
        // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
        // 那么本节点就是处于被覆盖状态
        return 2;
    }
}
