package me.khabib.math;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;
        for(int num: nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber2().singleNumber(new int[]{2, 2, 3, 2}));
    }
}
