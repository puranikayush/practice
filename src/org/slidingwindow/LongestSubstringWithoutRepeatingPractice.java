package org.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem: Longest Substring Without Repeating Characters
 *
 * Given a string s, return the length of the longest substring
 * without repeating characters.
 */
public class LongestSubstringWithoutRepeatingPractice {

    public static void main(String[] args) {

        String s = "abcddabcdebcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        int i = 0, j = 0;
        int max=0;
        while (j < s.length()) {
            while (set.contains(charArray[j])) {
                set.remove(charArray[i]);
                i++;
            }
            set.add(charArray[j]);
            j++;
            max=Math.max(max, set.size());
        }

        return max;
    }
}