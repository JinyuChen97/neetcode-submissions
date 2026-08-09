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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check = head;
        // 1. 检查是否存在至少 k 个节点
        for(int i=0;i<k;i++){
            if(check==null) return head;
            check=check.next;
        }
        
        // 2. 递归反转后续链表，check 此时正好指向下一组的头节点
        ListNode prev = reverseKGroup(check,k);

        // 3. 反转当前的 k 个节点，并将尾部连接到递归返回的 prev
        ListNode curr = head;
        for(int i=0;i<k;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}

