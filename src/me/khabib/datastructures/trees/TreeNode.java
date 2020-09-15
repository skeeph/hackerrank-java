package me.khabib.datastructures.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(Integer... values){
        return build(values, 0);
    }

    private static TreeNode build(Integer[] values, int k){
        if (k>=values.length || values[k]==null) return null;
        TreeNode root = new TreeNode(values[k]);
        root.left=build(values,2*k+1);
        root.right=build(values,2*k+2);
        return root;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", (" + left +
                "), (" + right +
                ")}";
    }
}
