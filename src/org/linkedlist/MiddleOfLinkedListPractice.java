package org.linkedlist;

/*
 * Problem: Middle of the Linked List
 *
 * Given the head of a singly linked list,
 * return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second one.
 *
 * Example:
 *
 * Input:
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * Output:
 * 3
 */
public class MiddleOfLinkedListPractice {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = middleNode(head);

        System.out.println(result.val);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}