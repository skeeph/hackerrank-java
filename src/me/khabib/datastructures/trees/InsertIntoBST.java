package me.khabib.datastructures.trees;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val >= val) {
            root.left = insertIntoBST(root.left, val);
        } else  {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new InsertIntoBST().insertIntoBST(TreeNode.build(4, 2, 7, 1, 3), 5);
        System.out.println(treeNode);
    }
}
