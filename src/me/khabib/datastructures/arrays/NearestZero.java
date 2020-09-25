package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class NearestZero {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    result[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                updateCell(matrix, result, i, j);
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                updateCell(matrix, result, i, j);

            }
        }

        return result;
    }

    private void updateCell(int[][] matrix, int[][] result, int i, int j) {
        if (result[i][j] != 0) {
            if (i - 1 >= 0)
                result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
            if (i + 1 < matrix.length)
                result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
            if (j - 1 >= 0)
                result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
            if (j + 1 < matrix[0].length)
                result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);

        }
    }

}
