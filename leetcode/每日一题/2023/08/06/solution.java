//24.两两交换链表中的节点
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead;
        ListNode left,right;
        ListNode temp;
        left = head;
        head = head.next;
        left.next = null;
        right = head;
        head = head.next;
        right.next = null;
        newHead = temp = right;
        temp = temp.next = left;
        while(true){
            // System.out.println(right.next != null);
            if(head != null) {
                left = head;
                head = head.next;
                left.next = null;
            }
            else{
                temp.next = null;
                break;
            }
            if(head != null) {
                right = head;
                head = head.next;
                right.next = null;
            }
            else{
                temp.next = left;
                break;
            }
            temp = temp.next = right;
            temp = temp.next = left;
        }
        return newHead;
    }
}