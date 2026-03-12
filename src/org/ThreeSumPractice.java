package org;

import java.util.*;

public class ThreeSumPractice {

    /*
     * Problem:
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, j != k and nums[i] + nums[j] + nums[k] == 0.
     *
     * The solution set must not contain duplicate triplets.
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int fixedNum = nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j<k) {
                int sum = fixedNum + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(fixedNum, nums[j], nums[k]));
                    j++;
                    k--;
                } else {
                    if (sum > 0)
                        k--;
                    else
                        j++;
                }
            }

        }


        return new ArrayList<>(res);
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4, 2};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));
        System.out.println("Expected: [[-1, -1, 2], [-4, 2, 2], [-1, 0, 1]]");
        System.out.println();

        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));
        System.out.println("Expected: []");
        System.out.println();

        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSum(nums3));
        System.out.println("Expected: [[0,0,0]]");
    }
}