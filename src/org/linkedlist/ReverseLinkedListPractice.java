package org.linkedlist;

import java.util.*;

/**
 * Reverse Linked List
 * <p>
 * Reverse a singly linked list and return the new head.
 */
public class ReverseLinkedListPractice {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});

        System.out.println("Original List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode dummy = null;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            current.next = dummy;
            dummy=current;
            current = next;
        }
        return dummy;
    }

    /**
     * Utility: Build linked list from array
     */
    public static ListNode buildList(int[] nums) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int n : nums) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }

        return dummy.next;
    }

    /**
     * Utility: Print linked list
     */
    public static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
}