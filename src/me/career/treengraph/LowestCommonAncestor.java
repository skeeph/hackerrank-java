package me.career.treengraph;

import me.khabib.datastructures.trees.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * CCIn 4.8
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left == null) ? right : ((right == null) ? left : root);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(root);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, p, q));
    }
}
