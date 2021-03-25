package com.yzsjy.code.sort;

/**
 * @author SUNJUNYAN
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        sort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];
            int index;
            for (index = i -1; index >= 0 && insertVal < a[index]; index--) {
                a[index + 1] = a[index];
            }
            a[index + 1] = insertVal;
        }
    }
}
