package org;

import java.util.*;

public class FourSumPractice {

    /*
     * Problem:
     * Given an integer array nums and an integer target,
     * return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
     * such that:
     *
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     *
     * Conditions:
     * - a, b, c, and d are all distinct indices
     * - The solution set must not contain duplicate quadruplets
     */

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }


    // Optional helper if you want to implement generalized kSum
    public static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(start>nums.length) return res;

        if(k==2){
            int left=start;
            int right=nums.length-1;

            while(left<right){
                int sum=nums[left] + nums[right];
                if(sum==target){
                    res.add(List.of(nums[left], nums[right]));
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1]) left++;
                    while (left<right && nums[right]==nums[right+1]) right--;
                } else if (sum>target) {
                    right--;
                } else {
                    left++;
                }
            }
            return res;
        }

        for (int i = start; i < nums.length - k + 1; i++) {
            //if (nums[i] > k) break;
            if (i > start && nums[i] == nums[i - 1]) continue;

            List<List<Integer>> lists = kSum(nums, i + 1, k - 1, target - nums[i]);
            for (List<Integer> list : lists) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(list);
                res.add(temp);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        System.out.println("Test Case 1");
        System.out.println("Input: " + Arrays.toString(nums1) + " target=" + target1);
        System.out.println("Output: " + fourSum(nums1, target1));
        System.out.println("Expected: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]");
        System.out.println();


        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println("Test Case 2");
        System.out.println("Input: " + Arrays.toString(nums2) + " target=" + target2);
        System.out.println("Output: " + fourSum(nums2, target2));
        System.out.println("Expected: [[2,2,2,2]]");
        System.out.println();


        // Test Case 3
        int[] nums3 = {-3, -1, 0, 2, 4, 5};
        int target3 = 2;

        System.out.println("Test Case 3");
        System.out.println("Input: " + Arrays.toString(nums3) + " target=" + target3);
        System.out.println("Output: " + fourSum(nums3, target3));
        System.out.println("Expected: [[-3,-1,2,4]]");
    }
}