package me.khabib.datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return constructBalancedSearchTree(inorder, 0, inorder.size()-1);
    }

    TreeNode constructBalancedSearchTree(List<TreeNode> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = inorder.get(mid);
        root.left = constructBalancedSearchTree(inorder, start, mid-1);
        root.right = constructBalancedSearchTree(inorder, mid+1, end);
        return root;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root);
        inorderTraversal(root.right, inorder);
        root.left = null;
        root.right = null;
    }
}
