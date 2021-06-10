package me.khabib.dp;

import java.util.Arrays;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }

    public int climbStairsDP(int n) {


        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairs(int n, int[] memo) {

        if (n < 0) return 0;
        else if (n == 0) return 1;
        else if (memo[n] > -1) return memo[n];
        else {
            int x = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
            memo[n] = x;
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(45));
    }
}
