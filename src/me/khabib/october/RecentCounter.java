package me.khabib.october;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class RecentCounter {
    LinkedList<Integer> window;
    public static final Integer BEFORE = 3000;

    public RecentCounter() {
        window = new LinkedList<>();
    }

    public int ping(int t) {
        window.add(t);
        while (window.size() > 0) {
            if (window.getFirst() < t - BEFORE) {
                window.removeFirst();
            } else break;
        }
        return window.size();
    }


    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
