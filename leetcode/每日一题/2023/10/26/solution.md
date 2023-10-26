2520. 统计能整除数字的位数

```java
class Solution {
    public int countDigits(int num) {
        int temp = num;
        int res = 0;
        while(temp != 0){
            if(num % (temp % 10) == 0) res ++;
            temp /= 10;
        }

        return res;
    }
}
```