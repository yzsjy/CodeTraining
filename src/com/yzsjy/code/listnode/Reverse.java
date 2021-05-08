package com.yzsjy.code.listnode;

/**
 * 链表反转
 * @author yzsjy
 */
public class Reverse {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     *反转前k个结点
     */
    private ListNode recent;
    public ListNode reverseN(ListNode head, int k) {
        if (k == 1) {
            recent = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, k - 1);
        head.next.next = head;
        head.next = recent;
        return last;
    }

    /**
     * 反转区间a到b链表
     * @param head
     * @param a
     * @param b
     * @return
     */
    public ListNode reverseBetween(ListNode head, int a, int b) {
        if (a == 1) {
            return reverseN(head, b);
        }
        head.next = reverseBetween(head.next, a - 1, b - 1);
        return head;
    }

    /**
     * 反转区间结点a到区间结点b到结点
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 每k个结点反转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
