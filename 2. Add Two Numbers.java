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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until all digits and carry are processed
        while (l1 != null || l2 != null || carry != 0) {
            // Get current values or 0 if a list is exhausted
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate total and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // Create a new node with the digit value and move pointer
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next nodes if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the result list starting from dummy's next
        return dummy.next;
    }
}
