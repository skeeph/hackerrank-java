package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * R;
            R *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{
                1, 2, 3, 4
        })));
    }
}
