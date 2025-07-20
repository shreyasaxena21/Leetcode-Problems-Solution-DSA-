class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Start from the dummy node
        ListNode current = dummy;

        // Traverse and remove matching nodes
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // Skip the node
            } else {
                current = current.next;
            }
        }

        return dummy.next; // Return the updated head
    }
}
