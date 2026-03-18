package org.array;

/*
 * Problem: Product of Array Except Self
 *
 * Given an array nums, return an array such that:
 * answer[i] = product of all elements except nums[i]
 *
 * Constraints:
 * - No division
 * - O(n) time
 */
public class ProductExceptSelfPractice {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prefix = new int[l];
        int[] postfix = new int[l];

        prefix[0] = 1;
        postfix[l-1]=1;

        for (int i = 0; i < l - 1; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }

        for (int i = l - 1; i > 0; i--) {
            postfix[i - 1] = postfix[i] * nums[i];
        }

        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            res[i] = prefix[i] * postfix[i];
        }


        return res;
    }
}