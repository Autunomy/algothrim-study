贪心题

东西方向和南北方向可以分别单独算，以东西方向为例，设当前向西走left，向东走了right
则当前的横坐标为x = ABS(left-right)
此时将t个向西走的步骤改为向东走，则最大横坐标为x = ABS( (left - t) - (right + t) ) = ABS(left - rght + 2 * t)
根据题意可以得出 t一定是min(left,right,k)
同理结算南北方向最大纵坐标，不断的循环计算，最终得出答案

```java
class Solution {

    int num;

    public int maxDistance(String s, int k) {
        
        int[] arr = new int['Z'];
        int res = 0;
        for(int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            arr[c] ++;
            num = k;
            res = Math.max(res, fun(arr['N'], arr['S']) + fun(arr['W'], arr['E']));
        }

        return res;
    }

    public int fun(int left,int right) {
        int temp = Math.min(left, Math.min(right, num));
        num -= temp;
        return Math.abs(left - right) + 2 * temp;
    }
}
```