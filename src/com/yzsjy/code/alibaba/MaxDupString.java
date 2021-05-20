package com.yzsjy.code.alibaba;

public class MaxDupString {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = k; i > 0; i--) {
            for (int j = 0; j + i < nums.length; j++) {
                if ((long)nums[j] - (long)nums[j + i] <= t && (long)nums[j] - (long)nums[j + i] >= -t) {
                    return true;
                }
            }
        }
        return false;
    }
}
