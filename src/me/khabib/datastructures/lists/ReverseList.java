package me.khabib.datastructures.lists;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseList().reverseList(
                ListNode.build(1, 2, 3, 4, 5)
        ));
    }
}
