[2595]奇偶位数
简单位运算

```java
class Solution {
    public int[] evenOddBit(int n) {
        int[] a = new int[2];
        while(n != 0) {
            if((n & 1) == 1) {
                a[0] ++;
            }
            n >>= 1;
            if((n & 1) == 1) {
                a[1] ++;
            }
            n >>= 1;
        }

        return a;
    }
}
```