package org;

import java.util.*;

/**
 * Problem: Valid Parentheses
 * <p>
 * Pattern:
 * Stack
 * <p>
 * Core Idea:
 * Track opening brackets and ensure closing brackets match.
 */
public class ValidParenthesesPractice {

    public static void main(String[] args) {

        String s = "{[]}";

        boolean result = isValid(s);

        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if (null == s || s.isEmpty()) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> pStack = new Stack<>();
        Set<Character> openSet = Set.of('(', '{', '[');
        Set<Character> closeSet = Set.of(')', '}', ']');
        char[] charArray = s.toCharArray();
        for (char bracket : charArray) {
            if (openSet.contains(bracket)) pStack.push(bracket);
            else if (closeSet.contains(bracket)) {
                if (pStack.isEmpty()) return false;
                Character open = pStack.pop();
                if (')' == bracket && '(' != open) return false;
                if ('}' == bracket && '{' != open) return false;
                if (']' == bracket && '[' != open) return false;
            }
        }
        return pStack.isEmpty();
    }
}