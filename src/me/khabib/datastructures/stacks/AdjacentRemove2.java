package me.khabib.datastructures.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/
 */
public class AdjacentRemove2 {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) return s;
        Stack<Character> prev = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        char[] chars = s.toCharArray();
        prev.add(chars[0]);
        counts.add(1);

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!prev.empty() && prev.peek().equals(c)) {
                if (counts.peek() + 1 == k) {
                    Integer equals = counts.pop();
                    while (equals > 0) {
                        prev.pop();
                        equals--;
                    }
                } else {
                    prev.push(c);
                    counts.push(counts.pop() + 1);
                }

            } else {
                prev.add(c);
                counts.add(1);
            }
        }

        return prev.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new AdjacentRemove2().removeDuplicates("deeedbbcccbdaa", 3));
    }
}
