package org.array;

/*
 * Problem: Container With Most Water
 *
 * Given an array height[], find two lines that form the container
 * holding the maximum amount of water.
 */
public class ContainerWithMostWaterPractice {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }


        return max;
    }
}