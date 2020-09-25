package me.khabib.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class SortByBits {
    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr).boxed().sorted(Comparator.comparingInt(this::countSetBits).thenComparing(Integer::compareTo)).mapToInt(x -> x).toArray();
    }

    int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortByBits().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }
}
