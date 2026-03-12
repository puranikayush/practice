package org;

import java.util.*;

/**
 * Problem: Subarray Sum Equals K
 * <p>
 * Pattern:
 * Prefix Sum + HashMap
 * <p>
 * Core Idea:
 * Track cumulative sums and check if a previous prefix
 * sum exists that would make the subarray sum = k.
 */
public class SubarraySumEqualsKPractice {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {

        int solCount = 0;
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (i == j) j++;
            else {
                int sum = 0;
                //int
            }

        }


        return solCount;
    }
}