package me.career.treengraph;

import me.khabib.datastructures.trees.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * ССIn 4.4
 */
public class IsBalancedTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }

    private Result helper(TreeNode node) {
        if (node == null) return new Result(true, 0);


        Result left = helper(node.left);
        Result right = helper(node.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean currentBalanced = Math.abs(left.height - right.height) <= 1;
        return new Result(left.balanced && right.balanced && currentBalanced, height);
    }


    private static class Result {
        boolean balanced;
        int height;

        Result(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }

    }


    public static void main(String[] args) {
        System.out.println(new IsBalancedTree().isBalanced(TreeNode.build(1, 2, 2, 3, 3, null, null, 4, 4)));
    }
}
