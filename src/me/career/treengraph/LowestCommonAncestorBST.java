package me.career.treengraph;

import me.khabib.datastructures.trees.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left = Integer.compare(root.val, p.val);
        int rigth = Integer.compare(root.val, q.val);
        if (left == 0 || rigth == 0) return root;
        else if (left != rigth) return root;
        else return lowestCommonAncestor(left > 0 ? root.left : root.right, p, q);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        System.out.println(new LowestCommonAncestorBST().lowestCommonAncestor(root, p, q));
    }
}
