package me.khabib.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        return uniquePaths(m - 1, n - 1, paths);
    }


    public int uniquePathsIter(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                if (i == 0) {
                    if (j > 0) paths[i][j] = paths[i][j - 1];
                } else if (j == 0) {
                    paths[i][j] = paths[i - 1][j];
                } else paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n, int[][] arr) {
        if (m < 0 || n < 0) return 0;
        else if (arr[m][n] > 0) {
            return arr[m][n];
        } else {
            int c = uniquePaths(m, n - 1, arr) + uniquePaths(m - 1, n, arr);
            arr[m][n] = c;
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
        System.out.println(new UniquePaths().uniquePathsIter(3, 7));
    }
}
