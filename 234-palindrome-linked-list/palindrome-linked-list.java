class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode headSecond = reverseList(slow);
        ListNode rereverse = headSecond;
        
        ListNode firstHalf = head;
        while (headSecond != null) {
            if (firstHalf.val != headSecond.val) {
                reverseList(rereverse);
                return false;
            }
            firstHalf = firstHalf.next;
            headSecond = headSecond.next;
        }
        
        reverseList(rereverse);
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode a= head.next;
        ListNode newHead = reverseList(a);
        a.next = head;
        head.next = null;
        return newHead;
    }
}
