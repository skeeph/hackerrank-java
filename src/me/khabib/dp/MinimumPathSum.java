package me.khabib.dp;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j > 0) grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}
