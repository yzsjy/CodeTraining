package com.yzsjy.code.sort;

/**
 * @author SUNJUNYAN
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        mergeSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        //找出中间索引
        int center = (left + right) / 2;
        //对左边数组进行递归
        sort(a, left,center);
        //对右边数组进行递归
        sort(a, center + 1, right);
        //合并
        merge(a, left, center, right);
        print(a);
    }

    /**
     * 将两个数组进行归并，归并前面两个数组已有序，归并后数组依然有序
     * @param a 数组对象
     * @param left 左数组的第一个元素的索引
     * @param center 左数组最后一个元素的索引， center + 1 是右数组第一个元素的索引
     * @param right 右数组最后一个元素的索引
     */
    public static void merge(int[] a, int left, int center, int right) {
        //临时数组
        int[] tmpArray = new int[a.length];
        int mid = center + 1;
        //记录临时数组的索引
        int third = left;
        //缓存左数组第一个元素的索引
        int tmp = left;

        while (left <= center && mid <= right) {
            if (a[left] <= a[mid]) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[mid++];
            }
        }
        while (mid <= right) {
            tmpArray[third++] = a[mid++];
        }
        while (left <= center) {
            tmpArray[third++] = a[left++];
        }

        //将临时数组中的内容拷贝到原数组中
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
