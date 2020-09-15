package me.khabib.datastructures.trees;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        if (root.left!=null && root.left.val>=root.val) return false;
        if (root.right!=null && root.right.val<=root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new IsValidBST().isValidBST(TreeNode.build(10,5,15,null,null,6,20)));
    }
}
