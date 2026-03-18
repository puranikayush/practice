package org.array;

/**
 * Problem: Find the Duplicate Number
 * <p>
 * Given an array nums containing n + 1 integers where
 * each integer is between 1 and n inclusive.
 * <p>
 * Return the duplicate number.
 * <p>
 * Constraints:
 * - Do not modify the array
 * - Use O(1) extra space
 */
public class FindDuplicateNumberPractice {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        int result = findDuplicate(nums);

        System.out.println(result);
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}