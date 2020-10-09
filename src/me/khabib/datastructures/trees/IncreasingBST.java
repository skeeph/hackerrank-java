package me.khabib.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(Integer.MIN_VALUE);
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);

        TreeNode cur = node;
        for (Integer integer : nodes) {
            cur.right = new TreeNode(integer);
            cur = cur.right;
        }
        return node.right;
    }

    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }


    public static void main(String[] args) {
        System.out.println(new IncreasingBST().increasingBST(TreeNode.build(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)));
    }
}
