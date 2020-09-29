package me.khabib.datastructures.heaps;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 */
class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > size) pq.poll();
        }

    }

    public int add(int val) {
        pq.add(val);

        if(pq.size() > size){
            pq.poll();
        }

        return pq.peek();

    }


    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }
}