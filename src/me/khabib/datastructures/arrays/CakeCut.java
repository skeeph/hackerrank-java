package me.khabib.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class CakeCut {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hd = getMaxCutOnDimension(h, horizontalCuts);

        long wd = getMaxCutOnDimension(w, verticalCuts);

        int mod = 1000000007;
        long ans = ((hd%mod)*(wd%mod))%mod;
        return (int)ans;
    }

    private long getMaxCutOnDimension(int h, int[] cuts) {
        Arrays.sort(cuts);
        int hd = cuts[0];
        for (int i = 1; i < cuts.length; i++) {
            hd = Math.max(hd, cuts[i] - cuts[i - 1]);
        }
        hd = Math.max(hd, h - cuts[cuts.length - 1]);
        return hd;
    }

    public static void main(String[] args) {
        System.out.println(new CakeCut().maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }
}
