package org.stack;

import java.util.*;

public class NextGreaterElementPractice {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2, 4};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        int i=nums1.length;
        int j=nums2.length;
//        while(j>i){
//            if(nums2)
//            j--;
//        }
        return res;
    }
}