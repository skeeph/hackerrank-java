package me.khabib.datastructures.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(new TreeNode(1));
        return generateTrees(1, n);

    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }


        for (int j = start; j <= end; j++) {
            List<TreeNode> leftTress = generateTrees(start, j - 1);
            List<TreeNode> rightTress = generateTrees(j + 1, end);

            for (TreeNode leftTree : leftTress) {
                for (TreeNode rightTree : rightTress) {
                    TreeNode current = new TreeNode(j);
                    current.left = leftTree;
                    current.right = rightTree;
                    result.add(current);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new UniqueBST2().generateTrees(3));
    }
}
