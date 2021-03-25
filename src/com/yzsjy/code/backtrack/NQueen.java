package com.yzsjy.code.backtrack;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 回溯
 * N皇后问题
 * 框架：
 * void bacTrack(...) {
 *     for 选择 : 选择列表 {
 *         做选择
 *         backTrack(...)
 *         删除选择
 *     }
 * }
 * @author SUNJUNYAN
 */
public class NQueen {
    private static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> sort = solveNQueen(n);
        for (List list : sort) {
            for (Object s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '0';
            }
        }
        backTrack(board, 0);
        return res;
    }

    /**
     * 计算所有可能
     * @param board
     * @param row
     */
    public static void backTrack(char[][] board, int row) {
        if (board.length == row) {
            res.add(construct(board));
            return;
        }

        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backTrack(board, row + 1);
            board[row][i] = '0';
        }
    }

    /**
     * 计算一种可能路径
     * @param board
     * @param row
     * @return
     */
    public static boolean backtrack(char[][] board, int row) {
        if (board.length == row) {
            res.add(construct(board));
            return true;
        }

        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            if (backtrack(board, row + 1)) {
                return true;
            }
            board[row][i] = '0';
        }
        return false;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
