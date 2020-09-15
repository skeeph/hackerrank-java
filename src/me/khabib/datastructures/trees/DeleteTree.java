package me.khabib.datastructures.trees;

public class DeleteTree {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;

            if (root.right == null) return root.left;

            TreeNode min = getMinimum(root.right);
            min.left = root.left;
            return root.right;
        }
        return root;
    }

    private TreeNode getMinimum(TreeNode root) {
        TreeNode x = root;
        while (x.left != null) x = x.left;
        return x;
    }

    private TreeNode findNode(TreeNode root, int key) {
        if (root == null || root.val == key) return root;
        if (root.val > key) return findNode(root.left, key);
        else return findNode(root.right, key);
    }

    public static void main(String[] args) {
        Integer[] values = new Integer[]{1, null, 2};
        TreeNode root = TreeNode.build(values);
        System.out.println(new DeleteTree().deleteNode(root, 2));
    }
}
