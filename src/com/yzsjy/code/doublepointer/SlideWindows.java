package com.yzsjy.code.doublepointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口
 * @author yzsjy
 */
public class SlideWindows {
    public void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            int num = need.getOrDefault(tmp, 0);
            need.put(tmp, num + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内的一系列更新

            System.out.println("window: [" + left + ", " + right + "]");

            //判断左窗口是否要收缩
            while (window.size() > valid) {
                //d是将移出窗口的字符
                char d = s.charAt(left);
                left++;
                //进行窗口内数据的一系列更新
            }
        }
    }

    /**
     * 最小覆盖子串
     * 给你一个字符串s、一个字符串t，请在字符串s中找出包含t所有字母的最小子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            int num = need.getOrDefault(tmp, 0);
            need.put(tmp, num + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == (int) need.get(c)) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d) == (int) need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 字符串排列
     * 判断s中是否存在t的排列
     * @param t
     * @param s
     * @return
     */
    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            int num = need.getOrDefault(tmp, 0);
            need.put(tmp, num + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == (int) need.get(c)) {
                    valid++;
                }
            }

            System.out.println("window: [" + left + ", " + right + "]");

            //判断左窗口是否要收缩
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if ((int) window.get(d) == (int) need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    /**
     * 找所有字母的异位词
     * 输入一个字符串s，一个字符串t，找到s中所有t的排列，返回它们的起始索引
     * @param s
     * @param t
     * @return
     */
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            int num = need.getOrDefault(tmp, 0);
            need.put(tmp, num + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if ((int) window.get(c) == (int) need.get(c)) {
                    valid++;
                }
            }

            System.out.println("window: [" + left + ", " + right + "]");

            //判断左窗口是否要收缩
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if ((int) window.get(d) == (int) need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }

    /**
     * 最长无重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
