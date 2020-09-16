package me.khabib.datastructures.lists;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode fictive = new ListNode(-1, head);

        ListNode prev = fictive;
        while (prev.next != null && prev.next.next!=null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            ListNode next = second.next;

            second.next = null;
            first.next = null;


            prev.next = second;
            second.next = first;
            first.next = next;


            prev = first;
        }


        return fictive.next;
    }

    public static void main(String[] args) {
        System.out.println(new SwapNodes().swapPairs(
                ListNode.build(1,2,3)
        ));
    }
}
