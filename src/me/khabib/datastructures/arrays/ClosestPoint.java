package me.khabib.datastructures.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class ClosestPoint {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingDouble(x -> Math.sqrt(x[0] * x[0] + x[1] * x[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ClosestPoint().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
