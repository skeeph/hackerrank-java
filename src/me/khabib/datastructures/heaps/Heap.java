package me.khabib.datastructures.heaps;

public class Heap {
    private int[] A;
    private int heapSize;

    public Heap(int[] a) {
        A = a;
        buildMaxHeap();
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (heapSize > 0 && left <= heapSize && A[left] > A[largest]) largest = left;
        if (heapSize > 0 && right <= heapSize && A[right] > A[largest]) largest = right;
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
        heapSize = A.length;
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

    public void insert(int k) {
        heapSize++;
        checkArraySize();
        A[heapSize] = k;

        int i = heapSize;
        int parent = i / 2;
        while (i > 0 && A[i] > A[parent]) {
            swap(i, parent);
            i = parent;
        }
    }

    private void checkArraySize() {
        if (heapSize >= A.length) {
            int[] temp = new int[heapSize * 2];
            System.arraycopy(A, 0, temp, 0, A.length);
            A = temp;
        }
    }

    public int size() {
        return heapSize;
    }
}
