package me.khabib.dp;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        return uniquePaths(m - 1, n - 1, paths, obstacleGrid);
    }


    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] s = new int[m][n];
        s[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) s[i][j] = 0;
                else if (i == 0) {
                    if (j > 0) s[i][j] = s[i][j - 1];
                } else if (j == 0) {
                    s[i][j] = s[i - 1][j];
                } else s[i][j] = s[i - 1][j] + s[i][j - 1];
            }
        }
        return s[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n, int[][] arr, int[][] maze) {
        if (m < 0 || n < 0) return 0;
        else if (maze[m][n] > 0) {
            return 0;
        } else if (arr[m][n] > 0) {
            return arr[m][n];
        } else {
            int c = uniquePaths(m, n - 1, arr, maze) + uniquePaths(m - 1, n, arr, maze);
            arr[m][n] = c;
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstaclesDP(new int[][]{{1}}));
    }
}
