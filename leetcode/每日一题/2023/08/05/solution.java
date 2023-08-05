//	21.合并两个有序链表
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = list1;
        ListNode p = temp;
        while(temp != null && list2 != null){
            if(temp.val < list2.val){
                p = temp;
                temp = temp.next;
            }else{
                ListNode x = list2;
                list2 = list2.next;
                if(temp == list1){
                    list1 = p = x;
                    x.next = temp;
                }else{
                    x.next = temp;
                    p.next = x;
                    p = x;
                }
            }
        }

        if(list2 != null){
            if(p != null){
                p.next = list2;
            }else if(temp != null){
                temp.next = null;
            }else{
                return list2;
            }
        } 

        return list1;
    }
}