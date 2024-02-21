package org.example.daimasuixianglu.tu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 22:35:25
 */
public class leet130 {
    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][board[0].length - 1] == 'O') {
                dfs(board, r, board[0].length - 1);
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[board.length - 1][c] == 'O') {
                dfs(board, board.length - 1, c);
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'A') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        // if (!isArea(board, r, c)) {
        //     return;
        // }
        if (board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'A';
        // 访问上、下、左、右四个相邻结点
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }

    public boolean isArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
