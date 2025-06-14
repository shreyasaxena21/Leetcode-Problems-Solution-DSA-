/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //approach 1(iusing set as a visited set)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //set
        Set<ListNode> set = new HashSet<>();
        while(headB!=null){
            set.add(headB);
            headB = headB.next;
        }
        while(headA!=null){
            if(set.contains(headA)){
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }

    //approach 2
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a!=b){
            a = (a==null) ? headA : a.next;
            b = (b==null) ? headB : b.next;
        }
        return a;


     }
}