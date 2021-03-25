package com.yzsjy.code.sort;

/**
 * @author SUNJUNYAN
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        shellSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellSort(a, dk);
            dk /= 2;
        }
    }

    //类似插入排序，只是插入排序的增量为1，这里的增量是dk
    public static void shellSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];
                a[i] = a[i - dk];
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;
            }
        }
    }
}
