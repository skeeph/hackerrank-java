package me.khabib.backtraking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, candidates, 0, target, 0);
        return result;
    }


    public void helperFunction(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target, int sum) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            helperFunction(result, current, candidates, i, target, sum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
