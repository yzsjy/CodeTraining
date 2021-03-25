package com.yzsjy.code.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 回溯
 * 全排列问题
 * void bacTrack(...) {
 *     for 选择 : 选择列表 {
 *         做选择
 *         backTrack(...)
 *         删除选择
 *     }
 * }
 * @author SUNJUNYAN
 */
public class FullArrangement {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> sort = permute(nums);
        for (List lists : sort) {
            for (Object i : lists) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track);
        return res;
    }

    /**
     * 路径，记录在track中
     * @param nums
     * @param track
     */
    public static void backTrack(int[] nums, List<Integer> track) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backTrack(nums, track);
            //取消选择
            track.remove(track.size() - 1);
        }
    }
}
