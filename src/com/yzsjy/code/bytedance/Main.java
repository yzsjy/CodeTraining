package com.yzsjy.code.bytedance;

//import java.text.DecimalFormat;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String in = sc.nextLine();
//        int win = Integer.parseInt(in.split(":")[1]);
//        String[] nums = in.split(":")[0].split(",");
//        int[] num = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            num[i] = Integer.parseInt(nums[i]);
//        }
//
//        double sum = 0;
//        double res = 0;
//        for (int i = 0; i < num.length - win; i++) {
//            if (i == 0) {
//                for (int j = i; j < i + win; j++) {
//                    sum += num[j];
//                }
//            } else {
//                double tmp = sum;
//                sum -= num[i - 1];
//                sum += num[i + win - 1];
//                res = Math.max(res, (sum - tmp) / tmp);
//            }
//        }
//        res *= 100;
//        DecimalFormat df = new DecimalFormat("0.00");
//        System.out.println("" + df.format(res) + "%");
////        System.out.println(res);
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String in = sc.nextLine();
//        in = in.split("\\[")[1].split("\\]")[0];
//        String[] rains = in.split(",");
//        int[] rain = new int[rains.length];
//        for (int i = 0; i < rains.length; i++) {
//            rain[i] = Integer.parseInt(rains[i]);
//        }
//        boolean isTrue = true;
//        List<Integer> visited = new ArrayList<>();
//        int[] tmp = new int[rains.length];
//        int[] ans = new int[rains.length];
//        for (int i = 0; i < rains.length; i++) {
//            if (rain[i] == 0) {
//                visited.add(i);
//            } else {
//                if (tmp[rain[i]] != 0) {
//                    int day = i;
//                    for (int v : visited) {
//                        day = Math.min(day, v);
//                    }
//                    if (day != i) {
//                        ans[i] = -1;
//                        ans[day] = rain[i];
//                        visited.remove(visited.indexOf(day));
//                    } else {
//                        isTrue = false;
//                        break;
//                    }
//                } else {
//                    ans[i] = -1;
//                    tmp[rain[i]] = 1;
//                }
//            }
//        }
//        if (isTrue) {
//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append("[");
//            for (int i = 0; i < ans.length - 1; i++) {
//                stringBuffer.append(ans[i] + ",");
//            }
//            stringBuffer.append(ans[ans.length - 1] + "]");
//            System.out.println(stringBuffer.toString());
//        } else {
//            System.out.println("[]");
//        }
//    }
//}