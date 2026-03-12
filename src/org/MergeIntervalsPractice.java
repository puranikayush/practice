package org;

import java.util.*;

/**
 * Problem: Merge Intervals
 * <p>
 * Pattern:
 * Sorting + Greedy
 * <p>
 * Core Idea:
 * Sort intervals by start time and merge overlapping ones.
 */
public class MergeIntervalsPractice {

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {4, 5},
                {2, 6},
                {8, 10},
                {15, 18},
                {10, 12},
                {12, 15}
        };

        int[][] result = merge(intervals);

        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] merge(int[][] intervals) {
        int[][] sol = new int[intervals.length][2];
        //int max=0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            sol[j][0] = start;
            sol[j][1] = end;
            j++;
        }

        return Arrays.copyOfRange(sol,0,j);
    }
}