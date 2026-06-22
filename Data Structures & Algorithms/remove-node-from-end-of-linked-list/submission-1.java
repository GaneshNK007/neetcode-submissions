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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        int cnt=0;
        if(head.next==null) return null;

        while(first!=null && cnt!=n){
            first=first.next;
            cnt++;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode second=dummy;

        while(first!=null){
            first=first.next;
            second=second.next;
        }

        second.next=second.next.next;

        return dummy.next;
    }
}
