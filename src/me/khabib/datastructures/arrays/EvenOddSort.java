package me.khabib.datastructures.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/sort-array-by-parity
 */
public class EvenOddSort {
    public int[] sortArrayByParity(int[] A) {
        return IntStream.of(A).boxed().sorted(Comparator.comparingInt(x -> x % 2)).mapToInt(x -> x).toArray();
    }

    public int[] sortArrayByParityBest(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new EvenOddSort().sortArrayByParityBest(new int[]{3, 1, 2, 4})));
    }
}
