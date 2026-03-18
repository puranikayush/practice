package org.stack;

import java.util.*;

public class ValidParenthesesPractice {

    public static void main(String[] args) {

        String s = "([{)])";

        boolean result = isValid(s);

        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if (s == null) return true;
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')' -> {
                        if (stack.pop() != '(') return false;
                    }

                    case '}' -> {
                        if (stack.pop() != '{') return false;
                    }

                    case ']' -> {
                        if (stack.pop() != '[') return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}