package org;

import java.util.*;

/**
 * Problem: Subsets
 * <p>
 * Generate all possible subsets of a given array.
 * <p>
 * Pattern:
 * Backtracking
 * <p>
 * Core Idea:
 * For every element we have two choices:
 * include it OR skip it.
 */
public class SubsetsPractice {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = subsets(nums);

        System.out.println("Total subsets: " + result.size());
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList<>());
        calculateSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void calculateSubsets(int[] nums, int start, List<Integer> sol, List<List<Integer>> res) {
        res.add(new ArrayList<>(sol));
        for (int i = start; i < nums.length; i++) {
            sol.add(nums[i]);
            calculateSubsets(nums, i + 1, sol, res);
            sol.removeLast();
        }
    }


}