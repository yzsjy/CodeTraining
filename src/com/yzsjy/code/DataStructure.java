package com.yzsjy.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DataStructure {
    public static void main(String[] args) {
        testDeque();
    }

    public static void testDeque() {
        Deque<Character> deque = new LinkedList<>();
        deque.addFirst('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addFirst('d');
        deque.addFirst('e');
        while (!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }

        Deque<Integer> arrayDeque = new ArrayDeque<>();
    }
}
