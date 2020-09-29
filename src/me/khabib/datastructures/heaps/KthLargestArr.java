package me.khabib.datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestArr {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestArr().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
