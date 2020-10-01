package me.khabib.datastructures.trees;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node==null) return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;

        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        System.out.println(new IsValidBST().isValidBST(TreeNode.build(10,5,15,null,null,6,20)));
    }
}
