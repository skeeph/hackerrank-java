package me.career.treengraph;

import me.khabib.datastructures.trees.TreeNode;

import java.util.Arrays;

/**
 * 4.2
 */
public class BuildTree {
    public TreeNode build(int[] arr) {
        Arrays.sort(arr);
        return build(arr, 0, arr.length - 1);
    }

    TreeNode build(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(arr[mid]);
        if (mid != start) {
            treeNode.left = build(arr, 0, mid - 1);
        }
        if (mid != end) {
            treeNode.right = build(arr, mid + 1, end);
        }
        return treeNode;

    }

    public static void main(String[] args) {
        TreeNode build = new BuildTree().build(new int[]{3, 4, 1, 2, 6, 33, 34, 43, 20, 88, 99});
        System.out.println(build);
    }
}
