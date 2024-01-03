2487. 从链表中移除节点

```java
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
    public ListNode removeNodes(ListNode head) {
        int[] s = new int[100010];
        int top = -1;
        ListNode temp = head.next;
        s[++top] = head.val;
        while(temp != null){
            while(top != -1 && temp.val > s[top]){
                top--;
            }
            s[++top] = temp.val;
            temp = temp.next;
        }
        int i=0;
        temp = null;
        ListNode p = temp;
        while(head != null){
            if(head.val == s[i]){
                i++;
                if(temp == null){
                    temp = p = head;
                    head = head.next;
                    p.next = null;
                }else{
                    p.next = head;
                    head = head.next;
                    p = p.next;
                    p.next = null;
                }
            }else if(head.val < s[i]) head = head.next;
        }
        return temp;
    }
}
```