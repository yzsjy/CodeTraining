package com.yzsjy.code.microsoft;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] X = new int[s.length()];
        int[] Y = new int[s.length()];
        for (int i = 0; i <s.length(); i++) {
            X[i] = sc.nextInt();
        }
        for (int i = 0; i <s.length(); i++) {
            Y[i] = sc.nextInt();
        }
        System.out.println(getMini(s, X, Y));
    }

    public static int getMini(String S, int[] X, int[] Y) {
        Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char tmp = S.charAt(i);
            int sum = X[i] * X[i] + Y[i] * Y[i];
            PriorityQueue<Integer> queue;
            if (map.containsKey(tmp)) {
                queue = map.get(tmp);
            } else {
                queue = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
            }
            queue.offer(sum);
            map.put(tmp, queue);
        }
        int[] min = new int[map.size()];
        int maxLength = Integer.MAX_VALUE;
        int i = 0;
        for (Map.Entry<Character, PriorityQueue<Integer>> entry : map.entrySet()) {
            char key = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            min[i] = value.poll();
            if (!value.isEmpty()) {
                maxLength = Math.min(maxLength, value.poll());
            }
            i++;
        }
        Arrays.sort(min);
        int count = 0;
        for (int m : min) {
            if (m >= maxLength) {
                break;
            }
            count++;
        }
        return count;
    }
}
