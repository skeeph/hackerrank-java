package me.khabib.math;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = x / Math.abs(x);
        x = Math.abs(x);

        int count = -1;
        int temp = x;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }

        int result = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            result += lastDigit * Math.pow(10, count);
            if (result==Integer.MAX_VALUE) return 0;
            count--;
            x = x / 10;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
