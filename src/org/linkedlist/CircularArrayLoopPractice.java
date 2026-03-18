package org.linkedlist;

/*
 * Problem: Circular Array Loop
 *
 * Given a circular array of integers nums where each element indicates
 * the number of steps to move forward or backward.
 *
 * Determine if there is a cycle in the array.
 *
 * Conditions:
 * - Cycle must contain more than one element
 * - Movement must stay in same direction
 *
 * Example:
 *
 * Input:
 * nums = [2,-1,1,2,2]
 *
 * Output:
 * true
 */
public class CircularArrayLoopPractice {

    public static void main(String[] args) {

        int[] nums = {2, -1, 1, 2, 2};

        boolean result = circularArrayLoop(nums);

        System.out.println(result);
    }

    public static boolean circularArrayLoop(int[] nums) {


        int slow = 0;
        int fast = 0;


        return false;
    }
}