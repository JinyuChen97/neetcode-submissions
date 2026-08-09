/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode prev = dummy;
        ListNode current = head;

        while(current!=null&&current.next!=null){
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next=next;
        }
        return prev.next;
    }
}
