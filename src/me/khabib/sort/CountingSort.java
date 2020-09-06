package me.khabib.sort;

import java.util.Arrays;

public class CountingSort {
    public static int[] sort(int [] a, int k){
        int[] c = new int[k+1];
        for (int i : a) {
            c[i]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i]=c[i]+c[i-1];
        }

        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]]-1]=a[i];
            c[a[i]]--;
        }

        return b;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{9,1,1,1,1,2,2,3,2,4, 2, 3, 4, 1, 3, 10}, 10)));
    }
}
