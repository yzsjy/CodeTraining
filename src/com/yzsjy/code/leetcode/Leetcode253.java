package com.yzsjy.code.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode253 {

    public boolean isPrefixString(String s, String[] words) {
        int start = 0;
        int end = s.length() - 1;
        for (String word : words) {
            if (start > end) {
                break;
            }
            int len = word.length();
            if ((start + len) > (end + 1)) {
                return false;
            }
            String t = s.substring(start, start + len);
            if (!t.equals(word)) {
                return false;
            }
            start = start + len;
        }
        return start == (end + 1) ? true : false;
    }

    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < piles.length; i++) {
            queue.offer(piles[i]);
        }
        for (int i = 0; i < k; i++) {
            int t = queue.poll();
            t = t - t / 2;
            queue.offer(t);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count += queue.poll();
        }
        return count;
    }

    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int[] d = new int[nums.length + 1];
        for (int num : nums) {
            if (num > d[len]) {
                d[++len] = num;
            } else {
                int l = 1;
                int r = len;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid] < num) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[r] = num;
            }
        }
        return len;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        //最长上升子序列
        int[] stack = new int[obstacles.length];//恒定的
        int top = -1;
        int[] res = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            if (top == -1 || obstacles[i] >= stack[top]) {
                stack[++top] = obstacles[i];
                res[i] = top + 1;
            } else {
                //二分
                int l = 0, r = top, m;
                while (l < r) {
                    m = l + (r - l) / 2;
                    if (stack[m] <= obstacles[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                stack[r] = obstacles[i];
                res[i] = r + 1;
            }
        }
        return res;
    }
}
