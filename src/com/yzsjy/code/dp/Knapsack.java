package com.yzsjy.code.dp;

import java.util.Scanner;

/**
 * 动态规划
 * 0-1 背包问题
 * @author SUNJUNYAN
 */
public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[N];
        int[] val = new int[N];
        for (int i = 0; i < N; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            val[i] = sc.nextInt();
        }
        System.out.println(knapsack(W, N, wt, val));
    }

    public static int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                //当前容量装不下，只能选择不装入背包
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }
}
