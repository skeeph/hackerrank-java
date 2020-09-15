package me.khabib.datastructures.trees;

public class BSTIterator {
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;

    }


    /**
     * @return the next smallest number
     */
    public int next() {
        return nextHelper(root, root);

    }

    private int nextHelper(TreeNode parent, TreeNode node) {
        while (node.left != null) {
            parent = node;
            node = node.left;
        }
        final int res = node.val;
        if (node.right != null) {
            node.val = node.right.val;
            node.left = node.right.left;
            node.right = node.right.right;
        } else {
            if (parent == node) root = null;
            else parent.left = null;
        }
        return res;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return root != null;
    }
}
