package me.khabib.datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Heap pq = new Heap(new int[]{});
        for (int stone : stones) {
            pq.insert(stone);
        }

        while (pq.size() > 1) {
            Integer large = pq.getMax();
            Integer small = pq.getMax();
            if (!large.equals(small)) {
                pq.insert(large - small);
            }
        }

        return pq.size() == 1 ? pq.getMax() : 0;
    }


    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{
                2,7,4,1,8,1
        }));
    }
}
