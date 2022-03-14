package com.yzsjy.code.meituan;

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        List<int[]> lists = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            int n = sc.nextInt();
//            int[] in = new int[n];
//            for (int j = 0; j < n; j++) {
//                in[j] = sc.nextInt();
//            }
//            lists.add(in);
//        }
//        List<String> res = new ArrayList<>();
//        for (int[] list : lists) {
//            if (isTrue(list)) {
//                res.add("yes");
//            } else {
//                res.add("no");
//            }
//        }
//        for (String r : res) {
//            System.out.println(r);
//        }
//    }
//
//    public static boolean isTrue(int[] in) {
//        Set<Integer> visit = new HashSet<>();
//        int n = in.length;
//        for (int i : in) {
//            if (i > n || visit.contains(i)) {
//                return false;
//            } else {
//                visit.add(i);
//            }
//        }
//        return true;
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int len = s.length();
//
//        boolean[][] dp = new boolean[len][len];
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//
//        int maxLen = 0;
//        for (int l = 2; l <= len; l++) {
//            for (int i = 0; i < len; i++) {
//                int j = l + i - 1;
//                if (j >= len) {
//                    break;
//                }
//                if (s.charAt(i) != s.charAt(j)) {
//                    dp[i][j] = false;
//                } else {
//                    dp[i][j] = dp[i + 1][j - 1];
//                }
//            }
//            if (dp[len - l][len - 1] && l > maxLen) {
//                maxLen = l;
//            }
//        }
//        System.out.println(len - maxLen);
//    }
//}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            String s = sc.next();
            num[i] = m;
            if (s.equals("L")) {
                index.put(m, -(i + 1));
            } else {
                index.put(m, (i + 1));
            }
        }
        int[] res = new int[n];
        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty() && index.get(num[i]) < 0) {
                res[-index.get(num[i]) - 1] = -1;
            } else if (index.get(num[i]) > 0) {
                list.add(num[i]);
            } else if (!list.isEmpty() && index.get(num[i]) < 0) {
                int r = -1;
                for (int j = list.size() - 1; j >= 0; j--) {
                    int top = list.get(j);
                    if ((num[i] - top) % 2 == 0) {
                        int time = (num[i] - top) / 2;
                        res[index.get(top) - 1] = time;
                        res[-index.get(num[i]) - 1] = time;
                        r = j;
                        break;
                    }
                }
                if (r > 0) {
                    list.remove(r);
                } else {
                    res[-index.get(num[i]) - 1] = -1;
                }
            }
        }
        for (int i : list) {
            res[index.get(i) - 1] = -1;
        }
        for (int i : res) {
            System.out.println(i);
        }

    }
}