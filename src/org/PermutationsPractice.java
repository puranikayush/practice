package org;

import java.util.*;

/**
 * Problem: Permutations
 *
 * Given an array of DISTINCT integers nums,
 * return all possible permutations.
 *
 * A permutation is a rearrangement of elements.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Constraints:
 * 1 <= nums.length <= 6
 * All numbers are unique.
 *
 * Pattern:
 * Backtracking
 *
 * Backtracking Template:
 * choose → explore → un-choose
 *
 * Goal:
 * Generate all permutations of nums.
 */
public class PermutationsPractice {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        List<List<Integer>> result = permute(nums);

        System.out.printf("Permutations: %s\n", result.size());
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, new ArrayList<>(), used, res);

        return res;
    }

    private static void permute(int[] nums, ArrayList<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i]=true;
            permute(nums, path, used, res);
            path.removeLast();
            used[i]=false;
        }

    }

}