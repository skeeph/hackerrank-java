package me.khabib.datastructures.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        while (!stack2.empty()) stack1.add(stack2.pop());
        stack1.add(x);
        while (!stack1.empty()) stack2.add(stack1.pop());
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
