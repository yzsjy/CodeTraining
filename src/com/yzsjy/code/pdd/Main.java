package com.yzsjy.code.pdd;

//import java.util.Scanner;
//
//public class Main {
//
//    public static void Main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] in = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                in[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(isTrue(n, in));
//    }
//
//    public static boolean isTrue(int n, int[][] in) {
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (in[i][0] >= in[j][0] && in[i][1] <= in[j][1]) {
//                    return true;
//                }
//                if (in[i][0] <= in[j][0] && in[i][1] >= in[j][1]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}

//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//    public static void Main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] in = new int[2][n];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < n; j++) {
//                in[i][j] = sc.nextInt();
//            }
//        }
//        int[] res = getResult(n, in);
//        System.out.println(res[0] + " " + res[1]);
//    }
//
//    public static int[] getResult(int n, int[][] in) {
//        int a = 0;
//        int b = 0;
//        int i = 0;
//        int j = 0;
//        Stack<Integer> stack = new Stack<>();
//        boolean aOrb = true;
//        while (i < n && j < n) {
//            int tmp = 0;
//            int count = 0;
//            if (aOrb) {
//                tmp = in[0][i];
//                if (stack.contains(tmp)) {
//                    while (stack.peek() != tmp) {
//                        stack.pop();
//                        count++;
//                    }
//                    stack.pop();
//                    count += 2;
//                    if (++i < n) {
//                        stack.push(in[0][i]);
//                    }
//                } else {
//                    stack.push(tmp);
//                    i++;
//                }
//                a += count;
//                aOrb = false;
//            } else {
//                tmp = in[1][j];
//                if (stack.contains(tmp)) {
//                    while (stack.peek() != tmp) {
//                        stack.pop();
//                        count++;
//                    }
//                    stack.pop();
//                    count += 2;
//                    if (++j < n) {
//                        stack.push(in[1][j]);
//                    }
//                } else {
//                    stack.push(tmp);
//                    j++;
//                }
//                b += count;
//                aOrb = true;
//            }
//        }
//        while (i < n) {
//            stack.push(in[0][i]);
//        }
//
//        while (j < n) {
//            stack.push(in[0][j]);
//        }
//        while (!stack.isEmpty()) {
//            int tmp = stack.pop();
//            if (tmp % 2 != 0) {
//                a++;
//            } else {
//                b++;
//            }
//        }
//        return new int[] {a, b};
//    }
//}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] in = new int[n][4];
//        int[] out = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 4; j++) {
//                in[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            out[i] = getNum(i, in);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(out[i]);
//        }
//    }
//
//    public static int getNum(int i, int[][] in) {
//        int a = in[i][0];
//        int b = in[i][1];
//        int c = in[i][2];
//        int q = in[i][3];
//        while (q > 0) {
//            if (q % c == 0) {
//                int n = q / c;
//                if ((n - a) % b == 0) {
//                    return 1;
//                }
//            } else {
//                q = q - b;
//            }
//        }
//        return 0;
//    }
//}


//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<int[][]> in = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            int m = sc.nextInt();
//            int[][] input = new int[m][2];
//            for (int x = 0; x < m; x++) {
//                for (int y = 0; y < 2; y++) {
//                    input[x][y] = sc.nextInt();
//                }
//            }
//            in.add(input);
//        }
//        List<Integer> res = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            int[][] t = in.get(i);
//            res.add(getMax(t));
//        }
//
//        for (int r : res) {
//            System.out.println(r);
//        }
//    }
//
//    public static int getMax(int[][] t) {
//        int sum = 0;
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o2[1] - o1[1];
//                }
//                return o2[0] - o1[0];
//            }
//        });
//        int max = 0;
//        for (int i = 0; i < t.length; i++) {
//            queue.offer(new int[] {t[i][0], t[i][1]});
//            max = Math.max(max, t[i][1]);
//        }
//        int[] visit = new int[max];
//        while (!queue.isEmpty()) {
//            int[] tmp = queue.poll();
//            int day = tmp[1] - 1;
//            boolean has = false;
//            while (day >= 0) {
//                if (visit[day] == 0) {
//                    visit[day] = 1;
//                    has = true;
//                    break;
//                }
//                day--;
//            }
//            if (has) {
//                sum += tmp[0];
//            }
//        }
//        return sum;
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] in = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                in[i][j] = sc.nextInt();
            }
        }
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(getMin(in[i]));
        }
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static int getMin(int[] t) {
        int num = 0;
        int start = t[0];
        int end = t[1];
        if (start == end) {
            return num;
        } else if (start > end) {
            int m = start - end;
            if (m % 2 == 1) {
                num = 1 + m / 2;
            } else {
                num = m / 2;
            }
        } else if (start < end) {
            if ((end - start) < ((start + 1) / 2)) {
                return end - start;
            }
            if (end % 2 == 1) {
                end = (end + 1) / 2;
            } else {
                end /= 2;
            }
            num++;
            while (end > start) {
                if (end % 2 == 1) {
                    end = (end - 1) / 2;
                    num++;
                } else {
                    end /= 2;
                }
                num++;
            }
            if (end == start) {
                return num;
            }
            num = num + (start - end) / 2 + 1;
        }
        return num;
    }
}