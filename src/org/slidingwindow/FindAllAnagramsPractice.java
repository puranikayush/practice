package org.slidingwindow;

import java.util.*;

public class FindAllAnagramsPractice {

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);

        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String str, String p) {
        if (p.length() > str.length()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        Map<Character, Integer> reqMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            reqMap.put(p.charAt(i), reqMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
//        while (end < p.length()) {
//            windowMap.put(str.charAt(end), windowMap.getOrDefault(str.charAt(end), 0) + 1);
//            end++;
//        }

        int formed = 0;

        while (start <= end && end < str.length()) {
            char ch = str.charAt(end);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (reqMap.containsKey(ch) && (int) windowMap.get(ch) == (int) reqMap.get(ch)) {
                formed++;
            }
            while (formed == reqMap.size() && reqMap.containsKey(str.charAt(start)) && (int) windowMap.get(str.charAt(start)) == (int) reqMap.get(str.charAt(start))) {
                res.add(start);
                windowMap.put(str.charAt(start), windowMap.get(str.charAt(start)) - 1);
                start++;
                formed--;
            }
            end++;
        }
        return res;
    }
}