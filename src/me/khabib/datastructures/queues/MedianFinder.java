package me.khabib.datastructures.queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/submissions/
 */
public class MedianFinder {
    private Queue<Integer> minHeap, maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }


    public void addNum(Integer num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double findMedian() {
        double median;
        if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder x = new MedianFinder();
        x.addNum(1);
        x.addNum(2);
        System.out.println(x.findMedian());
        x.addNum(3);
        x.addNum(-1);
        System.out.println(x.findMedian());
    }
}