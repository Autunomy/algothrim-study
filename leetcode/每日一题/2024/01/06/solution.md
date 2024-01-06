2807. 在链表中插入最大公约数

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode q = head;
        while(q != null && q.next != null){
            int a = q.val;
            int b = q.next.val;
            int num = (int)gcd(a,b);
            ListNode temp = new ListNode(num,q.next);
            q.next = temp;
            q = temp.next;
        }
        return head;
    }
    long gcd(long a, long b) {long t;while(b!=0) {t=b;b=a%b;a=t;}return a;}
    long lcm(long a,long b){return (a*b)/gcd(a,b);}
}
```