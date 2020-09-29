package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquaresTwoPointers(int[] A) {
        int N = A.length;
        int j = 0;

        //Находим конец отрицательных
        while (j < N && A[j] < 0) {
            j++;
        }
        int i = j - 1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedSquares().sortedSquaresTwoPointers(new int[]{-4, -1, 0, 3, 10})));
    }
}
