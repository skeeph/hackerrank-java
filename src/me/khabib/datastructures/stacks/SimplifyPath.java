package me.khabib.datastructures.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.trim().equals("") || part.equals(".")) continue;
            else if (part.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else stack.push(part);
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../"));
    }
}
