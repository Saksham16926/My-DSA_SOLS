class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        ListNode smaller = smallerHead;
        ListNode greater = greaterHead;
    
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                smaller.next = current;
                smaller = smaller.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }
        
        greater.next = null;
        
        smaller.next = greaterHead.next;
        return smallerHead.next;
    }
}