```java
class Solution {
    public ListNode doubleIt(ListNode head) {
        int[] arr = new int[100010];
        int cnt = 0;

        while(head != null){
            arr[cnt ++] = head.val;
            head = head.next;
        }
        cnt --;

        int[] doubleArr = new int[100010];
        int cnt2 = 0;
        int jin = 0;
        while(cnt >= 0){
            int temp = arr[cnt] * 2;
            temp += jin;
            doubleArr[cnt2 ++] = temp % 10;
            jin = temp / 10;
            cnt -- ;
        }

        while(jin > 0){
            doubleArr[cnt2 ++] = jin % 10;
            jin /= 10;
        }

        head = null;
        for(int i=0;i<cnt2;++i){
            if(head == null){
                head = new ListNode(doubleArr[i],null);
            }else{
                ListNode temp = new ListNode(doubleArr[i],head);
                head = temp;
            }
        }
        return head;
    }
}
```