package me.khabib.strings;

import me.khabib.datastructures.trees.UniqueBST;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        // initializaion
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // function
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] | dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }




    public static void main(String[] args) {
        System.out.println(InterleavingStrings.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));
    }
}
