package me.khabib.datastructures.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class KDiiffs {
    public int findPairs(int[] nums, int k) {
        Set<Map.Entry<Integer, Integer>> pairs = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    if (nums[j] - nums[i] == k) {
                        pairs.add(Map.entry(nums[j], nums[i]));
                    }
                    if (nums[i] - nums[j] == k) {
                        pairs.add(Map.entry(nums[i], nums[j]));
                    }

                }
            }
        }
        return pairs.size();
    }

    public int findPairsNot(int[] nums, int k) {

        if (k < 0) return 0;
        Arrays.sort(nums);
        int left = 0, right = 1, count = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] > k) {
                left++;
            } else if (nums[right] - nums[left] < k || left == right) {
                right++;
            } else {
                count++;
                left++;
                right++;
                while (right < nums.length && nums[right] == nums[right - 1]) right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new KDiiffs().findPairsNot(new int[]{1, 3, 1, 5, 4}, 0));
    }
}
