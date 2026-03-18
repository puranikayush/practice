package org.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Minimum Window Substring
 *
 * Return the smallest substring of s that contains all characters of t.
 */
public class MinimumWindowSubstringPractice {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);

        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        if (t.length() > s.length()) return "";
        Map<Character, Integer> tFreqMap = getFreqMap(t);
        int b = 0, e = 0;
        int startIndex = -1, endIndex = -1;
//        while (e <= s.length() && b < s.length() && b < e) {
//            String sub = s.substring(b, e);
//            Map<Character, Integer> freqMap = getFreqMap(sub);
//            boolean equalFreq = compareMap(tFreqMap, freqMap);
//            if (equalFreq) {
//                startIndex = b;
//                endIndex = e;
//                b++;
//            } else {
//                e++;
//            }
//        }
        char[] sArray = s.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        while (e < s.length() && b <= e) {
            String sub = s.substring(b,e+1);
            sMap.put(sArray[e], sMap.getOrDefault(sArray[e], 0) + 1);
            while (compareMap(tFreqMap, sMap)) {
                sMap.put(sArray[b], sMap.get(sArray[b]) - 1);
                if (startIndex == -1 || (endIndex - startIndex > e - b)) {
                    startIndex = b;
                    endIndex = e;
                }
                b++;
            }
            e++;
        }
        return s.substring(startIndex, endIndex+1);
    }

    private static boolean compareMap(Map<Character, Integer> tFreqMap, Map<Character, Integer> freqMap) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : tFreqMap.entrySet()) {
            if (freqMap.get(characterIntegerEntry.getKey()) == null || characterIntegerEntry.getValue() > freqMap.get(characterIntegerEntry.getKey()))
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> getFreqMap(String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return freqMap;
    }
}