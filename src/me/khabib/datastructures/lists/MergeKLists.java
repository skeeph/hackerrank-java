package me.khabib.datastructures.lists;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;

        boolean updated;

        do {
            updated = false;
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list != null) {
                    updated = true;
                    if (list.val < minValue) {
                        minIndex = i;
                        minValue = list.val;
                    }
                }
            }
            if (updated){
                curr.next = lists[minIndex];
                curr = curr.next;
                lists[minIndex] = lists[minIndex].next;
            }
        } while (updated);


        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new MergeKLists().mergeKLists(
                new ListNode[]{
                        ListNode.build(1, 4, 5),
                        ListNode.build(1, 3, 4),
                        ListNode.build(2, 6)
                }
        ));
    }
}
