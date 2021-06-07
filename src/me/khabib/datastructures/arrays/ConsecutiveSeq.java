package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence
 */
public class ConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int currentSeq = 1;
        int longestSeq = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - prev) == 1) {
                prev = nums[i];
                currentSeq++;
            } else if (nums[i]==prev){
                continue;
            }else {
                prev = nums[i];
                longestSeq = Math.max(currentSeq, longestSeq);
                currentSeq = 1;
            }
        }
        return Math.max(currentSeq, longestSeq);
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveSeq().longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
