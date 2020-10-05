package me.khabib.math;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class Base10Complement {
    public int bitwiseComplement(int N) {
        if (N==0) return 1;
        int k = 0;
        int res = 0;
        while (N > 0) {
            int bit = N & 1;
            int x = (bit^1) << k;
            res = res + x;
            N = N >> 1;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Base10Complement().bitwiseComplement(0));
    }
}
