package me.khabib.sort;

import java.util.Arrays;

public class OrderStatistics <T extends Comparable>{
    static int findMedian(int[] arr, int i, int n) {
        if (i <= n)
            Arrays.sort(arr, i, n); // Sort the array
        else
            Arrays.sort(arr, n, i);
        return arr[n / 2]; // Return middle element
    }


    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4,9, 19, 26};
        int n = arr.length, k = 3;
        System.out.println("K'th smallest element is "
                + kthSmallest(arr, 0, n - 1, k));
    }

    private static int kthSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1;
            int i;
            int[] median = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(arr, l + i * 5, 5);

            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, n % 5);
                i++;
            }

            int medOfMed = (i == 1) ? median[i - 1] :
                    kthSmallest(median, 0, i - 1, i / 2);

            int pos = partition(arr, l, r, medOfMed);

            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1) // If position is more, recur for left
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int l, int r, int x) {
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x)
                break;
        swap(arr, i, r);
        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
