package me.khabib.datastructures.lists;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(hashCode());
        ListNode curr = result;
        int rem = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            rem = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + rem;
            rem = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + rem;
            rem = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l2 = l2.next;
        }

        if (rem!=0){
            curr.next = new ListNode(rem);
        }

        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(
                ListNode.build(5),
                ListNode.build(5)
        ));
    }
}
