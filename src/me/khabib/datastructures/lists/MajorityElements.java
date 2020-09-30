package me.khabib.datastructures.lists;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element-ii/
 */
public class MajorityElements {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.putIfAbsent(num, 0);
            freqs.put(num, freqs.get(num) + 1);
        }

        List<Integer> result = new ArrayList<>();
        freqs.forEach((num, count) -> {
            if (count > nums.length / 3) {
                result.add(num);
            }
        });

        return result;
    }

    public List<Integer> majorityElementMoore(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int N = nums.length;
        int count1 = 0, count2 = 0, cand1 = -1, cand2 = -1;

        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int i : nums) {
            if (cand1 == i) count1++;
            if (cand2 == i) count2++;
        }

        if (count1 > N / 3) {
            ans.add(cand1);
        }
        if (count2 > N / 3) {
            ans.add(cand2);
        }


        return ans;


    }

    public static void main(String[] args) {
        System.out.println(new MajorityElements().majorityElement(null));

    }
}
