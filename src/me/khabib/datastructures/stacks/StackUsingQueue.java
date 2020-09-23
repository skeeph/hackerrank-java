package me.khabib.datastructures.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class StackUsingQueue {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
        while (!queue2.isEmpty()) queue1.add(queue2.poll());
        while (!queue1.isEmpty()) queue2.add(queue1.poll());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}