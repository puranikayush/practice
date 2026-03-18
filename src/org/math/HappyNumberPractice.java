package org.math;

/*
 * Problem: Happy Number
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is defined as:
 * Repeatedly replace the number by the sum of the squares of its digits.
 * If the process ends in 1, the number is happy.
 *
 * If it loops endlessly in a cycle that does not include 1,
 * the number is not happy.
 *
 * Example:
 *
 * Input:
 * n = 19
 *
 * Output:
 * true
 */
public class HappyNumberPractice {

    public static void main(String[] args) {

        int n = 19;

        boolean result = isHappy(n);

        System.out.println(result);
        System.out.println(isHappy(4));


    }

    public static boolean isHappy(int n) {
        int slow = getDigitSquaredSum(n);
        int fast = getDigitSquaredSum(getDigitSquaredSum(n));
        while (fast != 1) {
            slow = getDigitSquaredSum(slow);
            fast = getDigitSquaredSum(getDigitSquaredSum(fast));
            if (slow == fast) return false;
        }
        return true;
    }

    private static int getDigitSquaredSum(int n) {
        int res = 0;
        int k = n;
        while (k != 0) {
            res = res + (int) Math.pow(k % 10, 2);
            k = k / 10;
        }
        return res;
    }
}