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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next= head;
        ListNode f=dummy;
        ListNode s=dummy;

        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }

        ListNode secondHead = s.next;
        s.next=null;

        ListNode newSecondHead = reverseSecond(secondHead);

        ListNode l1 = head;
        ListNode l2 = newSecondHead;
        while(l1!=null&&l2!=null){
            ListNode next = l1.next;
            ListNode next2= l2.next;

            l1.next = l2;
            l2.next = next;
            l1=next;
            l2=next2;
        }
    }

    ListNode reverseSecond(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null&&curr.next!=null){
            ListNode next = curr.next;
            curr.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return prev.next;
    }
}
