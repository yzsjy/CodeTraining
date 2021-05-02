package com.yzsjy.code.doublepointer;

/**
 * 快慢指针
 * @author yzsjy
 */
public class FastSlowPointer {
    class ListNode {
        int val;
        ListNode next;
        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 检测是否有环
     * 用两个指针，一个每次前进2步，一个每次前进1步，如果不包含环，跑的快的那个指针最终会碰到null，说明链表不包含环；
     * 如果含有环，快指针最终会超过慢指针1圈，和慢指针相遇，说明链表含有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找环的起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 寻找链表的中点
     * @param head
     * @return
     */
    public ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 寻找倒数第k个元素
     * @param head
     * @param k
     * @return
     */
    public ListNode getLastKNode(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int value = k;
        while (value-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
