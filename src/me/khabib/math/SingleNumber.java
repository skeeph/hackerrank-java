package me.khabib.math;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
