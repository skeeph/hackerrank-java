package me.khabib.math;

/**
 * https://leetcode.com/problems/number-of-1-bits/submissions/
 */
public class NumberOfOnes {
    public int hammingWeight(int n) {
        int sum = 0;
        int mask = 1;
        for (int i = 0; i <= 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            mask = mask << 1;
        }

        return sum;
    }

    public int reference(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(new NumberOfOnes().reference(0b1010));
    }
}
