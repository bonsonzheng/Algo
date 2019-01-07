import util.ListNode;

import static util.ListNode.build4NodesList;

/**
 * Problem desc in https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromTheEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0 ; i <=n ; i ++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = build4NodesList();

        ListNode listNode = removeNthFromEnd(head, 3);
        while(listNode != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }
}
