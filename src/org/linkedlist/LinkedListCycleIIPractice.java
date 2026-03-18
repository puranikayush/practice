package org.linkedlist;

/*
 * Problem: Linked List Cycle II
 *
 * Given the head of a linked list, return the node where the cycle begins.
 *
 * If there is no cycle, return null.
 *
 * Example:
 *
 * Input:
 * 3 -> 2 -> 0 -> -4
 *       ^         |
 *       |_________|
 *
 * Output:
 * Node with value 2
 */
public class LinkedListCycleIIPractice {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        ListNode result = detectCycle(head);

        System.out.println(result != null ? result.val : "null");
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}