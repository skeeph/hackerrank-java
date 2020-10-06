package me.khabib.datastructures.arrays;

import java.util.Arrays;

public class SelectRange {
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int start = extremeInsertionIndex(nums, target , true);
        res[0]=start;
        if (start == nums.length || nums[start] != target) {
            return res;
        }

        int end = extremeInsertionIndex(nums, target , false)-1;
        if (end > 0) res[1] = end;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SelectRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
