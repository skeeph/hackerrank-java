package me.khabib.datastructures.stacks;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
public class ProductOfNumbers {
    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public ProductOfNumbers() {

        head = new Node(Integer.MAX_VALUE);
        tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void add(int num) {
        Node node = new Node(num);

        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;

    }

    public int getProduct(int k) {
        Node node = tail.prev;
        int p = 1;
        while (k > 0) {
            p = p * node.val;
            node = node.prev;
            k--;
        }
        return p;
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));

    }
}
