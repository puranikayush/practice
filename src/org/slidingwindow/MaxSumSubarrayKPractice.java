package org.slidingwindow;

public class MaxSumSubarrayKPractice {

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSumSubarray(nums, k);

        System.out.println(result);
    }

    public static int maxSumSubarray(int[] nums, int k) {
        if (k > nums.length) return -1;
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (right < k - 1) {
            sum = sum + nums[right];
            right++;
        }
        while (right < nums.length) {
            sum = sum + nums[right];
            max = Math.max(max, sum);
            sum = sum - nums[left];
            left++;
            right++;
        }

        return max;
    }
}