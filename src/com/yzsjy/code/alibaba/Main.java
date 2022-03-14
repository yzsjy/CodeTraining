package com.yzsjy.code.alibaba;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] in = new int[n];
//        for (int i = 0; i < n; i++) {
//            in[i] = sc.nextInt();
//        }
//        int[] pre = new int[n + 1];
//        pre[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            pre[i] = pre[i - 1] + in[i - 1];
//        }
//        int maxI = 1;
//        int l = 1;
//        int r = n;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (pre[mid] > (pre[n] - pre[mid])) {
//                r = mid;
//            } else if (pre[mid] < (pre[n] - pre[mid])) {
//                l = mid + 1;
//            } else {
//                maxI = mid;
//                break;
//            }
//        }
//        System.out.println(maxI);
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] in = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                in[i][j] = sc.nextInt();
//                if (in[i][0] == 1 || in[i][0] == 2) {
//                    break;
//                }
//            }
//        }
//
//        if (n % 2 != 0) {
//            System.out.println(-1);
//            return;
//        }
//
//        int a = 0;
//        int b = 0;
//        List<Integer> isNull = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (in[i][0] == 1) {
//                a++;
//            } else if (in[i][0] == 2) {
//                b++;
//            } else {
//                isNull.add(i);
//            }
//        }
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//
//        for (int i : isNull) {
//            queue.offer(new int[] {i , in[i][2] - in[i][1]});
//        }
//        int sum = 0;
//        for (int i = 0; i < n / 2 - b; i++) {
//            sum += in[queue.poll()[0]][2];
//        }
//        for (int i = 0; i < n / 2 - a; i++) {
//            sum += in[queue.poll()[0]][1];
//        }
//        System.out.println(sum);
//    }
//}


//
//public class Main {
//    static int count = 0;
//    static int sum = 0;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] need = new char[n][n];
//        for (int x = 0; x < n; x++) {
//            String s = sc.next();
//            need[x] = s.toCharArray();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n; j++) {
//                if (need[i][j] == '.') {
//                    count++;
//                }
//            }
//        }
//        DFS(0, 0, 0, need);
//        System.out.println(sum);
//    }
//
//    public static void DFS(int a1, int a2, int time, char[][] need) {
//        if (a1 < 0 || a1 >= need.length - 2 || a2 < 0 || a2 >= need.length - 1) {
//            return;
//        }
//
//        if (need[a1][a2] == '#') {
//            return;
//        }
//
//        if (time == count) {
//            sum++;
//            return;
//        }
//
//
//        DFS(a1 - 1, a2, time + 1, need);
//        DFS(a1 + 1, a2, time + 1, need);
//        DFS(a1, a2 - 1, time + 1, need);
//        DFS(a1, a2 + 1, time + 1, need);
//    }
//}

//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] names = new String[n];
//        String[] scores = new String[n];
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            names[i] = s;
//        }
//
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            scores[i] = s;
//        }
//
//        String[] res = scoreSort(names, scores);
//        for (String s : res) {
//            System.out.print(s + " ");
//        }
//    }
//
//    public static String[] scoreSort(String[] names, String[] scores) {
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[1] - o1[1];
//            }
//        });
//        for (int i = 0; i < scores.length; i++) {
//            String[] splits = scores[i].split(",");
//            int count = 0;
//            for (String split : splits) {
//                count += Integer.parseInt(split);
//            }
//            queue.offer(new int[]{i, count});
//        }
//        String[] res = new String[names.length];
//        for (int i = 0; i < res.length; i++) {
//            int[] t = queue.poll();
//            res[i] = names[t[0]];
//        }
//        return res;
//    }

//    public static int getCount(int start, int end) {
//        int count = 0;
//        for (int i = start; i <= end; i++) {
//            if (isPrime(i) && isPalindrome(i)) {
//                count++;
//            }
//        }
//        return count;
//    }

//    public static boolean isPalindrome(int x) {
//        if (x < 0 || (x % 10 == 0 && x != 0)) {
//            return false;
//        }
//        int revertedNumber = 0;
//        while (x > revertedNumber) {
//            revertedNumber = revertedNumber * 10 + x % 10;
//            x /= 10;
//        }
//        return x == revertedNumber || x == revertedNumber / 10;
//    }
//
//    public static boolean isPrime(int n) {
//        for (int i = 2; i * i <= n; ++i) {
//            if (n % i == 0) {
//                return false;
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
//        int n = sc.nextInt();
//        int[] in = new int[n];
//        for (int i = 0; i < n; i++) {
//            in[i] = sc.nextInt();
//        }
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = getRes(in[i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(res[i]);
//        }
//    }
//
//    public static int getRes(int num) {
//        int sum = num / 3;
//        return (sum - 1) * (sum - 2) / 2;
//    }
//}

//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] strings = new String[n];
//        for (int i = 0; i < n; i++) {
//            strings[i] = sc.next();
//        }
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = getRes(strings[i]);
//        }
//
//        for (int i= 0; i < n; i++) {
//            System.out.println(res[i]);
//        }
//    }
//
//    public static int getRes(String s) {
//        int count = 0;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char t = s.charAt(i);
//            if (!stack.isEmpty() && t == stack.peek()) {
//                stack.pop();
//                continue;
//            }
//            if (t == '{') {
//                stack.push('}');
//            }
//            if (t == '[') {
//                stack.push(']');
//            }
//            if (t == ']' || t == '}') {
//                count++;
//                stack.pop();
//            }
//        }
//        return count;
//    }
//}