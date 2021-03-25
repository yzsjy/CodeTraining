package com.yzsjy.code.sort;

/**
 * @author SUNJUNYAN
 * 快速排序算法
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        sort(a, 0, a.length - 1);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            /*
                从后往前比较
                如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
             */
            while (end > start && a[end] >= key) {
                end--;
            }
            if (a[end] <= key) {
                int tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
            }
            /*
                从前往后比较
                如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
             */
            while (end > start && a[start] <= key) {
                start++;
            }
            if (a[start] >= key) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }

        }
        if (start > low) {
            sort(a, low, start - 1);
        }
        if (end < high) {
            sort(a, end + 1, high);
        }
    }
}
