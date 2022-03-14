package com.yzsjy.code.tencent;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String l1 = sc.nextLine();
//        String l2 = sc.nextLine();
//        int n = Integer.parseInt(l1.split(" ")[0]);
//        int k = Integer.parseInt(l1.split(" ")[1]);
//        String[] strings = l2.split(" ");
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(strings[i]);
//        }
//        int[] pre = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            pre[i] = a[i - 1] + pre[i - 1];
//        }
//
//        int l = 0;
//        int r = 0;
//
//        double maxAvg = 0;
//        for (int i = 0; i < n - k + 1; i++) {
//            for (int j = i + k - 1; j < n; j++) {
//                double minus = pre[j + 1] - pre[i];
//                int len = j - i + 1;
//                double avg = minus / len;
//                if (avg == maxAvg) {
//                    if (len > r - l + 1) {
//                        l = i;
//                        r = j;
//                    } else if (len == (r - l + 1)) {
//                        if (i < l) {
//                            l = i;
//                            r = j;
//                        }
//                    }
//                } else if (avg > maxAvg) {
//                    maxAvg = avg;
//                    l = i;
//                    r = j;
//                }
//            }
//        }
//        System.out.println(l + " " + r);
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    static int[] deng = new int[]{6,3,5,5,4,5,6,3,7,6};
//    static int[][] n = new int[][] {
//            {0,3,3,3,4,3,2,3,1,2},
//            {3,0,4,2,3,4,5,2,4,3},
//            {3,4,0,2,5,4,3,4,2,3},
//            {3,2,2,0,3,2,3,2,2,1},
//            {4,3,5,3,0,3,4,3,3,2},
//            {3,4,4,2,3,0,1,4,2,1},
//            {2,5,3,3,4,1,0,5,1,2},
//            {3,2,4,2,3,4,5,0,4,3},
//            {1,4,2,2,3,2,1,4,0,1},
//            {2,3,3,1,2,1,2,3,1,0}
//    };
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//        int len = num.length();
//        int[] nums = new int[len];
//        for (int i = 0; i < len; i++) {
//            nums[i] = num.charAt(i) - '0';
//        }
//        int[] res = new int[len];
//        for (int i = 1; i <= len; i++) {
//            int count = 0;
//            int[] tmp = new int[i];
//            for (int j = 0; j < i; j++) {
//                tmp[j] = nums[j];
//                count += deng[nums[j]];
//            }
//            for (int k = 1; k < len - i + 1; k++) {
//                for (int x = 0; x < i; x++) {
//                    if (tmp[x] != nums[k + x]) {
//                        count += n[tmp[x]][nums[k + x]];
//                        tmp[x] = nums[k + x];
//                    }
//                }
//            }
//            res[i - 1] = count;
//        }
//        for (int i = 0; i < len; i++) {
//            System.out.print(res[i] + " ");
//        }
//    }
//
//}

//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String l1 = sc.nextLine();
//        String l2 = sc.nextLine();
//        String l3 = sc.nextLine();
//        int n = Integer.parseInt(l1);
//        String[] s2 = l2.split(" ");
//        String[] s3 = l3.split(" ");
//        int[] edge = new int[s2.length];
//        int[] w = new int[s3.length];
//        for (int i = 0; i < s2.length; i++) {
//            edge[i] = Integer.parseInt(s2[i]);
//        }
//        for (int i = 0; i < s3.length; i++) {
//            w[i] = Integer.parseInt(s3[i]);
//        }
//        int del = edge.length;
//        int maxW = 0;
//        int l = 0;
//        int r = 0;
//        for (int i = 0; i < edge.length; i++) {
//            l = i;
//            r = edge[i] - 1;
//            maxW = Math.max(maxW, getMaxW(w, l, r));
//        }
//        System.out.println(del + " " + maxW);
//    }
//
//    public static int getMaxW(int[] w, int l, int r) {
//        int maxW = 0;
//        for (int i = 0; i < w.length; i++) {
//            for (int j = i + 1; j < w.length; j++) {
//                if ((i == l && j == r) || (i == r) && (j == l)) {
//                    continue;
//                }
//                maxW = Math.max(maxW, w[i] * w[j]);
//            }
//        }
//        return maxW;
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] in = new int[3];
//        for (int i = 0; i < 3; i++) {
//            in[i] = sc.nextInt();
//        }
//        int n = in[0];
//        int l = in[1];
//        int r = in[2];
//        int len = r - l + 1;
//        int [] t = new int[len];
//        System.out.println("0 0 0 1");
//
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] strings = new String[n];
//        for (int i = 0; i < n; i++) {
//            strings[i] = sc.next();
//        }
//        List<String> res = new ArrayList<>();
//        for (String s : strings) {
//            if (isTrue(s)) {
//                res.add("YES");
//            } else {
//                res.add("NO");
//            }
//        }
//        for (String r : res) {
//            System.out.println(r);
//        }
//    }
//
//    public static boolean isTrue(String s) {
//        Stack<Character> deque = new Stack<>();
//        if (s.charAt(0) == 'b' || s.charAt(s.length() - 1) == 'a' || s.length() == 1) {
//            return false;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char t = s.charAt(i);
//            if (deque.isEmpty() && t == 'b') {
//                return false;
//            } else if (t == 'a') {
//                deque.push(t);
//            } else if (!deque.isEmpty() && t == 'b') {
//                deque.pop();
//            }
//        }
//        if (!deque.isEmpty()) {
//            return false;
//        }
//        return true;
//    }
//}


//import java.util.HashMap;
//import java.util.Map;
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
//        Map<Integer, Integer> a = new HashMap<>();
//        Map<Integer, Integer> b = new HashMap<>();
//        for (int i = 0; i < n; i += 2) {
//            a.put(in[i], a.getOrDefault(in[i], 0) + 1);
//        }
//
//        for (int i = 1; i < n; i += 2) {
//            b.put(in[i], b.getOrDefault(in[i], 0) + 1);
//        }
//
//        int maxA = 0;
//        int maxB = 0;
//        for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
//            if (maxA < entry.getValue()) {
//                maxA = entry.getValue();
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : b.entrySet()) {
//            if (maxB < entry.getValue()) {
//                maxB = entry.getValue();
//            }
//        }
//
//        System.out.println(n - maxA - maxB);
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] size = new int[n][2];
//        int[][] location = new int[n][4];
//        List<char[][]> needs = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                size[i][j] = sc.nextInt();
//            }
//            for (int j = 0; j < 4; j++) {
//                location[i][j] = sc.nextInt();
//            }
//            char[][] need = new char[size[i][0]][size[i][1]];
//            for (int x = 0; x < size[i][0]; x++) {
//                String s = sc.next();
//                need[x] = s.toCharArray();
//            }
//            needs.add(need);
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int t = DFS(location[i][0] - 1, location[i][1] - 1, location[i][2] - 1, location[i][3] - 1, 0, needs.get(i));
//            res.add((location[i][0] * location[i][1]) ^ t ^ (location[i][2] * location[i][3]));
//        }
//
//        for (int i : res) {
//            System.out.println(i);
//        }
//    }
//
//    public static int DFS(int a1, int a2, int b1, int b2, int time, char[][] need) {
//        if (a1 >= need.length || a2 >= need[0].length || a1 < 0 || a2 < 0) {
//            return -1;
//        }
//        if ((a1 == b1 || a1 == (b1 - 1) || a1 == (b1 + 1)) && (a2 == b2 || a2 == (b2 - 1) || a2 == (b2 + 1))) {
//            return time;
//        }
//        if (need[a1][a2] == '#') {
//            return -1;
//        }
//        int u = DFS(a1 - 1, a2, b1, b2, time + 1, need);
//        int d = DFS(a1 + 1, a2, b1, b2, time + 1, need);
//        int l = DFS(a1, a2 - 1, b1, b2, time + 1, need);
//        int r = DFS(a1, a2 + 1, b1, b2, time + 1, need);
//        if (l < 0 && r < 0 && u < 0 && d < 0) {
//            return -1;
//        }
//        int max = Integer.MAX_VALUE;
//        if (u > 0) {
//            max = Math.min(max, u);
//        }
//        if (d > 0) {
//            max = Math.max(max, d);
//        }
//        if (l > 0) {
//            max = Math.min(max, l);
//        }
//        if (u > 0) {
//            max = Math.min(max, u);
//        }
//        return max;
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        String s = "?ab??a";
//        System.out.println(solution(s));
//    }
//    public static String solution(String S) {
//        // write your code in Java SE 8
//        int start = 0;
//        int end = S.length() - 1;
//        while (start < end) {
//            char m = S.charAt(start);
//            char n = S.charAt(end);
//            if (m != '?' && n != '?') {
//                if (m != n) {
//                    return "NO";
//                }
//            } else if (m != '?' && n == '?') {
//                S = S.substring(0, end) + m + S.substring(end + 1, S.length());
//            } else if (m == '?' && n != '?') {
//                S = S.substring(0, start) + n + S.substring(start + 1, S.length());
//            } else {
//                S = S.substring(0, start) + 'a' + S.substring(start + 1, end) + 'a' + S.substring(end + 1, S.length());
//            }
//        }
//        return S;
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] in = new int[n];
//        for (int i = 0; i < n; i++) {
//            in[i] = sc.nextInt();
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : in) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        int max = 0;
//        int index = 0;
//        List<Integer> same = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= max) {
//                if (entry.getValue() > max) {
//                    same = new ArrayList<>();
//                    index = entry.getKey();
//                    max = entry.getValue();
//                    same.add(entry.getKey());
//                } else {
//                    same.add(entry.getKey());
//                }
//
//            }
//        }
//        int l = 0;
//        int r = n - 1;
//        if (same.size() == 1) {
//            while (in[l] != index) {
//                l++;
//            }
//            while (in[r] != index) {
//                r--;
//            }
//        } else {
//            int len = Integer.MAX_VALUE;
//            for (int i : same) {
//                int a = 0;
//                int b = n - 1;
//                while (in[a] != index) {
//                    a++;
//                }
//                while (in[b] != index) {
//                    b--;
//                }
//                if (b - a + 1 < len) {
//                    len = b - a + 1;
//                    l = a;
//                    r = b;
//                }
//            }
//        }
//        System.out.println((l + 1) + " " + (r + 1));
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int x = sc.nextInt();
//        int[] in = new int[n];
//        for (int i = 0; i < n; i++) {
//            in[i] = sc.nextInt();
//        }
//        System.out.println(3);
//    }
//}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] in = new int[m][n];
        int[] order = new int[r];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                in[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            order[i] = sc.nextInt();
        }

        revert(order, in);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void revert(int[] order, int[][] in) {

    }
}