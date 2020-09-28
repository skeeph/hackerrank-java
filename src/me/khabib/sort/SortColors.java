package me.khabib.sort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums==null || nums.length<2) return;
        int[] freq = new int[3];
        for (int num : nums) {
            freq[num]++;
        }
        int k = 0;
        for (int color = 0; color < freq.length; color++) {
            while (freq[color] > 0) {
                nums[k] = color;
                k++;
                freq[color]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
}
