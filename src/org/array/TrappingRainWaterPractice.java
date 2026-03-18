package org.array;

/*
 * Problem: Trapping Rain Water
 *
 * Given an elevation map, compute how much water it can trap.
 */
public class TrappingRainWaterPractice {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


        System.out.println(trap_v1(height));
        System.out.println(trap_v2(height));
    }

    private static int trap_v2(int[] height) {
        int l = height.length;
        if (l <= 2) return 0;
        int[] left = new int[l];
        int[] right = new int[l];
        int leftMax = height[0];
        int rightMax = height[l - 1];

        for (int i = 1; i < l; i++) {
            left[i] = Math.max(0, leftMax - height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }

        for (int i = l - 1; i > 0; i--) {
            right[i - 1] = Math.max(0, rightMax - height[i - 1]);
            rightMax = Math.max(rightMax, height[i - 1]);
        }
        int res = 0;
        for (int i = 0; i < l; i++) {
            res = res + Math.min(left[i], right[i]);
        }
        return res;
    }

    public static int trap_v1(int[] height) {
        int l = height.length;
        if (l <= 2) return 0;
        int leftMax = height[0];
        int rightMax = height[l - 1];

        int res = 0;
        int left = 0, right = l - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res = res + (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res = res + (rightMax - height[right]);
                }
                right--;
            }
        }
        return res;
    }
}