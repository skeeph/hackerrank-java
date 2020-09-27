package me.khabib.datastructures.arrays;

import java.util.Arrays;

public class MergeSorted {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (second < 0) break;

            if (first >= 0 && nums1[first] > nums2[second]) {
                nums1[i] = nums1[first];
                first--;
            } else {
                nums1[i] = nums2[second];
                second--;
            }
        }

    }

    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 3, 0, 0, 0};
        new MergeSorted().merge(
                first, 3,
                new int[]{2, 5, 6}, 3
        );
        System.out.println(Arrays.toString(first));

    }
}
