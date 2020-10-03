package me.career.treengraph;

import me.khabib.datastructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * CCIn 4.3
 */
public class LevelsTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode node, List<List<Integer>> result, int level){
        if (node==null) return;
        if (result.size()<level+1) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        helper(node.left, result, level+1);
        helper(node.right, result, level+1);
    }
    public static void main(String[] args) {
        List<List<Integer>> levels = new LevelsTraversal().levelOrder(TreeNode.build(3, 9, 20, null, null, 15, 7));
        System.out.println(levels);
    }
}
