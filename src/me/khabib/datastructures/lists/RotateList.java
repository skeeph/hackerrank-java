package me.khabib.datastructures.lists;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null ) return head;
        int size = 0;
        ListNode curr = head;
        while (curr!=null){
            size++;
            curr=curr.next;
        }

        k = k%size;
        if (k==0) return head;


        ListNode slow = head;
        ListNode fast = head;
        while (k>0){
            fast=fast.next;
            k--;
        }

        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newHead = slow.next;
        slow.next=null;
        fast.next=head;

        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(new RotateList().rotateRight(
                ListNode.build(1,2), 2
        ));
    }
}
