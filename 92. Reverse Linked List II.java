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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }
        int count = 1;
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(count<left){
            prev = current;
            current = current.next;
            count++;
        }

        ListNode start = current;

        while(count !=right){
            current = current.next;
            count++;
        }

        next = current.next;
        current.next = null;

        ListNode newHead = reverse(start);
        if(prev!=null){
            prev.next = newHead;
        }

        start.next = next;

        if(left == 1) return newHead;

        return head;
    }

    ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;
    }
}