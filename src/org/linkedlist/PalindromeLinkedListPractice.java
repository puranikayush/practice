package org.linkedlist;

/*
 * Problem: Palindrome Linked List
 *
 * Given the head of a singly linked list, return true
 * if the list is a palindrome.
 *
 * Example:
 *
 * Input:
 * 1 → 2 → 2 → 1
 *
 * Output:
 * true
 */
public class PalindromeLinkedListPractice {

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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode list1 = head;
        ListNode list2 = reverseLinkedList(next);

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) return false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return (list1 == null || list1.next == null) && list2 == null;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}