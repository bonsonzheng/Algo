import util.ListNode;

/**
 * Problem desc in https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }

        return reverseNode(head, k, length);
    }

    public static ListNode reverseNode(ListNode head, int k, int length) {

        if (length < k) {
            return head;
        }

        ListNode pNext = head;
        ListNode pLastTail = null;
        ListNode originalHead = head;
        for (int i = 0; i < k; i++) {
            head = pNext;
            pNext = pNext.next;
            head.next = pLastTail;
            pLastTail = head;
        }

        originalHead.next = reverseNode(pNext, k, length - k);

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = reverseKGroup(util.ListNode.build6NodesList(), 2);
        System.out.println(listNode.toString());
    }

}
