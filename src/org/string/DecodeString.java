package org.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

    static void main() {
        String input = "10[a]4[bc]";
        System.out.println(decodeString(input));
    }

    private static String decodeString(String input) {
        Deque<Integer> numberStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        int k = 0;
        StringBuilder current = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = 10 * k + (ch - '0');
            } else if (ch == '[') {
                numberStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder parent = stringStack.pop();
                int count = numberStack.pop();
                parent.append(String.valueOf(current).repeat(Math.max(0, count)));
                current = parent;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
