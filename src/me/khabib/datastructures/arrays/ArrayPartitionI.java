package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i+=2) {
            result += Math.min(nums[i], nums[i + 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayPartitionI().arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
