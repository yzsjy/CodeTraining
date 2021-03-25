package com.yzsjy.code.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNJUNYAN
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        sort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] a) {
        //首先确定排序的趟数
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max= a[i];
            }
        }
        //确定位数
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        //建立10个队列
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> childQueue = new ArrayList<Integer>();
            queue.add(childQueue);
        }
        //进行time次分配和收集
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < a.length; j++) {
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> childQueue = queue.get(x);
                childQueue.add(a[j]);
                queue.set(x, childQueue);
            }
            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> childQueue = queue.get(k);
                    a[count] = childQueue.get(0);
                    childQueue.remove(0);
                    count++;
                }
            }
        }
    }
}
