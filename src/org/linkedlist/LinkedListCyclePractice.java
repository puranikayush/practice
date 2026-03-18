package org.linkedlist;

/*
 * Problem: Linked List Cycle
 *
 * Given the head of a linked list, determine if the linked list has a cycle.
 *
 * Return true if there is a cycle in the linked list, otherwise return false.
 *
 * Example:
 *
 * Input:
 * 3 -> 2 -> 0 -> -4
 *       ^         |
 *       |_________|
 *
 * Output:
 * true
 */
public class LinkedListCyclePractice {

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
        n4.next = n2; // creates cycle

        boolean result = hasCycle(head);

        System.out.println(result);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}