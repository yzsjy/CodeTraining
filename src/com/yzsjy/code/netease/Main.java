package com.yzsjy.code.netease;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        int n = sc.nextInt();
//        String[] strings = line.split(" ");
//        int[] num = new int[strings.length];
//        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].charAt(0) == '-') {
//                num[i] = -Integer.parseInt(strings[i].substring(1));
//            } else {
//                num[i] = Integer.parseInt(strings[i]);
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i + 1; j < num.length; j++) {
//                if (num[i] + num[j] <= n) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] strings = s.split(" ");
//        int[] age = new int[strings.length];
//        for (int i = 0; i < strings.length; i++) {
//            age[i] = Integer.parseInt(strings[i]);
//        }
//        int[] m = new int[age.length];
//        m[0] = 1;
//        int count = 1;
//        for (int i = 1; i < age.length; i++) {
//            if (age[i] <= age[i - 1]) {
//                m[i] = 1;
//            } else {
//                m[i] = m[i - 1] + 1;
//            }
//            count += m[i];
//        }
//        System.out.println(count);
//    }
//}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] in = new int[k][3];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                in[i][j] = sc.nextInt();
            }
        }

        int[][] map = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < k; i++) {
            map[in[i][0]][in[i][1]] = in[i][2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + map[i][j]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
