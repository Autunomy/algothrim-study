重点是gcd函数，编写出来后就是简单的链表操作

```java
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
}
```