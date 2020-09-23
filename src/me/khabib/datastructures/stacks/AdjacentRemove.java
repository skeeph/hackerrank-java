package me.khabib.datastructures.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
 */
public class AdjacentRemove {
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 2) return s;
        Stack<Character> prev = new Stack<>();
        char[] chars = s.toCharArray();
        prev.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!prev.empty() && prev.peek().equals(c)) {
                prev.pop();
            } else {
                prev.add(c);
            }
        }

        return prev.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new AdjacentRemove().removeDuplicates("abbaca"));
    }
}
