package com.yzsjy.code.leetcode;

/**
 * 原地操作数组
 * @author SUNJUNYAN
 */
public class ArraysOrigin {
    /**
     * 删除数组中的重复数字
     * 采用快慢指针的方式
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 删除数组中的指定元素
     * 采用快慢指针的方式
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 将数组中所有的0移到数组的末尾
     * 利用上面删除数组中指定的元素的方法先将数组中的0删除
     * 然后得到删除后数组的长度，然后在末尾添加0
     * @param nums
     */
    public void moveZeros(int[] nums) {
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
