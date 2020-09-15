package me.khabib.datastructures.trees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode right = invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=right;
        return root;
    }
}
