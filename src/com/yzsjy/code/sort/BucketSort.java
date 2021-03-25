package com.yzsjy.code.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author SUNJUNYAN
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        bucketSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void bucketSort(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int bucketNum = max - min  + 1;
        ArrayList<ArrayList<Integer>> bucketArray = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArray.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < a.length; i++) {
            int num = a[i] - min;
            bucketArray.get(num).add(a[i]);
        }

        for (int i = 0; i < bucketArray.size(); i++) {
            Collections.sort(bucketArray.get(i));
        }

        int k = 0;

        for (ArrayList<Integer> list : bucketArray) {
            for (Integer num : list) {
                if (num != null) {
                    a[k] = num;
                    k++;
                }
            }
        }
    }
}
