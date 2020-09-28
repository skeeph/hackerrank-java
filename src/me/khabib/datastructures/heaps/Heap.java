package me.khabib.datastructures.heaps;

public class Heap {
    private final int[] A;
    private int heapSize;

    public Heap(int[] a) {
        A = a;
        buildMaxHeap();
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left <= heapSize && A[left] > A[largest]) largest = left;
        if (right <= heapSize && A[right] > A[largest]) largest = right;
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }

    }

    private void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void buildMaxHeap() {
        heapSize = A.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private int left(int i) {
        return (i << 1);
    }

    private int right(int i) {
        return (i << 1) + 1;
    }

    public int getMax() {
        if (heapSize <= 0) return -1;
        int max = A[0];
        A[0] = A[heapSize];
        heapSize--;
        maxHeapify(0);
        return max;
    }
}
