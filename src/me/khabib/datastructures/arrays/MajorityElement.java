package me.khabib.datastructures.arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cand = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                cand = num;
                count++;
            } else if (num == cand) {
                count++;
            } else {
                count--;
            }
        }
        return cand;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
    }
}
