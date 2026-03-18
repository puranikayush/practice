package org.linkedlist;

import java.util.*;

/**
 * Remove Nth Node From End of List
 */
public class RemoveNthNodePractice {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        int n = 2;

        System.out.println("Original List:");
        printList(head);

        head = removeNthFromEnd(head, n);

        System.out.println("After Removal:");
        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode current = dummy;
        while (n>=0){
            current = current.next;
            n--;
        }
        ListNode temp = dummy;
        while (current!=null){
            current=current.next;
            temp=temp.next;
        }
        if(temp!=null && temp.next!=null){
            temp.next=temp.next.next;
        }
        return dummy.next;
    }

    /**
     * Utility: Build linked list
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
     * Utility: Print list
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