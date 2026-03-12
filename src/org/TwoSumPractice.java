package org;

import java.util.*;

public class TwoSumPractice {

    /*
     * Problem:
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * Assumptions:
     * - Exactly one solution exists.
     * - You may not use the same element twice.
     * - Return the indices in any order.
     */

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff))
                return new int[]{indexMap.get(diff),i };
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1}; // placeholder
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1)));
        System.out.println("Expected: [0, 1]");
        System.out.println();

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2)));
        System.out.println("Expected: [1, 2]");
        System.out.println();

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(nums3, target3)));
        System.out.println("Expected: [0, 1]");

        int[] nums4 = {3, 3};
        int target4 = 7;
        System.out.println("Test Case 4:");
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(twoSum(nums4, target4)));
        System.out.println("Expected: [-1, -1]");
    }
}