/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node idx = head;
        while(idx!=null){
            Node copyNode = new Node(idx.val);
            Node next = idx.next;

            idx.next = copyNode;
            copyNode.next = next;
            idx = next;
        }


        idx = head;
        while(idx!=null){
            Node copyNode = idx.next;
            if(idx.random!=null) copyNode.random = idx.random.next;
            idx=copyNode.next;
        }

        Node dummy = new Node(0);
        Node cIdx = dummy;
        idx = head;
        while(idx!=null){
            Node copy = idx.next;
            Node next = copy.next;

            cIdx.next = copy;
            cIdx = copy;
            idx.next = next;
            idx = next;
        }
        return dummy.next;
    }
}
