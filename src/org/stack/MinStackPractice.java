package org.stack;

import java.util.*;

public class MinStackPractice {

    public static void main(String[] args) {

        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.getMin()); // -3

        stack.pop();

        System.out.println(stack.top());    // 0
        System.out.println(stack.getMin()); // -2
    }
}

class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else {
            minStack.push(Math.min(val, minStack.peek()));
        }

    }

    public int getMin() {
        if (minStack.isEmpty()) throw new NoSuchElementException("No Element preset");
        return minStack.peek();
    }

    public int top() {
        if (stack.isEmpty()) throw new NoSuchElementException("No Element preset");
        return stack.peek();
    }

    public void pop() {
        if (stack.isEmpty()) throw new NoSuchElementException("No Element preset");
        stack.pop();
        minStack.pop();


    }
}