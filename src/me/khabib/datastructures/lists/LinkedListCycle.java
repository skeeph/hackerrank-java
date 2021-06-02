package me.khabib.datastructures.lists;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else return false;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2);
        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
