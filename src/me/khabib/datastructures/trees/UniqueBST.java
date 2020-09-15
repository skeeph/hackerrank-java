package me.khabib.datastructures.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBST {
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 0; root < i; root++) {
                int right = i - 1 - root;
                cache[i] += (cache[root] * cache[right]);
            }
        }
        return cache[n];

    }


    public static void main(String[] args) {
        System.out.println(new UniqueBST().numTrees(3));
    }
}
