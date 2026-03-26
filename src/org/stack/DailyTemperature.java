package org.stack;

import java.util.ArrayDeque;
import java.util.Arrays;


/*
* Given an array of integers temperatures represents the daily temperatures,
* return an array answer such that answer[i] is the number of days you have to
* wait after the ith day to get a warmer temperature. If there is no future day
* for which this is possible, keep answer[i] == 0 instead.
*
Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
* */

public class DailyTemperature {
    static void main() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        //int[] temperatures = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperature(temperatures)));
    }

    private static int[] dailyTemperature(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int cur = temperatures.length - 1;
        //ArrayDeque<Integer> valueStack = new ArrayDeque<>();
        ArrayDeque<Integer> idxStack = new ArrayDeque<>();
        while (cur >= 0) {
            while (!idxStack.isEmpty() && temperatures[idxStack.peek()] <= temperatures[cur]) {
                idxStack.pop();
            }
            if (!idxStack.isEmpty()) {
                res[cur] = idxStack.peek()-cur;
            }
            idxStack.push(cur);
            cur--;
        }
        return res;
    }
}
