package me.khabib.datastructures.trees;

import java.util.Arrays;

public class TreeFromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if (from > to) return null;

        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, from, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, to);
        return root;
    }


    public static void main(String[] args) {
        System.out.println(new TreeFromSortedArray().sortedArrayToBST(new int[]{
                -10, -3, 0, 5, 9}));
    }


}
