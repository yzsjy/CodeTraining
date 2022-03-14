package com.yzsjy.code.shopee;

import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public int calDPDScore(String dpdInfo) {
        // write code here
        Stack<Character> stack = new Stack<>();
        int size = 0;
        int sum = 0;
        for (int i = 0; i < dpdInfo.length(); i++) {
            char tmp = dpdInfo.charAt(i);
            if (tmp == 'N') {
                int num = stack.size();
                stack.clear();
                size = Math.max(num, size);

            } else {
                stack.push(tmp);
            }
        }
        if (size > 0 && size <= 3) {
            sum = - 10;
        } else if (size > 3 && size <= 7) {
            sum = - 15;
        } else if (size > 7) {
            sum = - 25;
        }
        return sum;
    }
}
