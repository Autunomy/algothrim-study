//142.环形链表 II
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next == head) return head;

        ListNode p1 = head;
        ListNode p2 = head;

        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                ListNode res = head;
                while(res != p1){
                    res = res.next;
                    p1 = p1.next;
                }
                return res;
            }
        }  
        return null;
    }
}