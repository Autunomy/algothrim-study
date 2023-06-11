class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return null;
        int sum = 0;
        for(ListNode p = head; p != null; p = p.next)
        {
            sum += p.val;
            if(sum == 0) return removeZeroSumSublists(p.next);
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}