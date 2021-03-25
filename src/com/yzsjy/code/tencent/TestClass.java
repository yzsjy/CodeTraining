package com.yzsjy.code.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] num = new int[T];
        for (int i = 0; i < T; i++) {
            num[i] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++) {
            System.out.println(getMin(num[i]));
        }
    }

    public static int getMin(int len) {

        int[] min = new int[len + 1];
        for (int j = 0; j <= len; j++) {
            if (j <= 2) {
                min[j] = j;
            } else if (j == 3) {
                min[j] = 2;
            } else if (j % 2 == 0 && j % 3 != 0) {
                min[j] = Math.min(min[j / 2] + 1, min[j - 1] + 1);
            } else if (j % 3 == 0 && j % 2 != 0) {
                min[j] = Math.min(min[j / 3] + 1, min[j - 1] + 1);
            } else if (j % 2 == 0 || j % 3 == 0) {
                int m = Math.min(min[j / 3] + 1, min[j / 2] + 1);
                min[j] = Math.min(m, min[j - 1] + 1);
            } else {
                min[j] = min[j - 1] + 1;
            }
        }
        return min[len];
    }

    


}
