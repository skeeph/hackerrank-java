package me.khabib.datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            Integer large = pq.poll();
            Integer small = pq.poll();
            if (!large.equals(small)) {
                pq.add(large - small);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }


    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{
                2, 2
        }));
    }
}
