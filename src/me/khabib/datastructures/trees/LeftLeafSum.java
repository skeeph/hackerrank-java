package me.khabib.datastructures.trees;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class LeftLeafSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        return sumLeft(root.left) + sumRight(root.right);
    }

    private int sumRight(TreeNode node) {
        if (node == null) return 0;
        return sumLeft(node.left) + sumRight(node.right);
    }

    private int sumLeft(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val;
        return sumLeft(node.left) + sumRight(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new LeftLeafSum().sumOfLeftLeaves(TreeNode.build(3, 9, 20, null, null, 15, 7)));
    }
}
