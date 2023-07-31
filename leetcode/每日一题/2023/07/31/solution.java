//143.重排链表
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while(head != null){
            list.add(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }

        int i=0,j=list.size() - 1;
        ListNode q = head;
        while(i <= j){
            if(head == null){
                head = list.get(i);
                q = head;
            }else{
                q.next = list.get(i);
                q = q.next;
            }
            i++;

            if(j >= i){
                q.next = list.get(j);
                q = q.next;
                j--;
            }
        }
    }
}