[灵神题解](https://www.bilibili.com/video/BV1Lm4y1N7mf/?share_source=copy_web&vd_source=cee0c756f49a6d9bab6e9167753f9dc4)

```java
class Solution {
    public long maximumSum(List<Integer> nums) {
        long ans = 0;
        int n = nums.size();
        long[] sum = new long[n + 1];
        for (int i = 0; i < nums.size(); i++) {
            int c = core(i + 1);
            sum[c] += nums.get(i);
            ans = Math.max(ans, sum[c]);
        }
        return ans;
    }

    private int core(int n) {
        int res = 1;
        for (int i = 2; i * i <= n; i++) {
            int e = 0;
            while (n % i == 0) {
                e ^= 1;
                n /= i;
            }
            if (e == 1) {
                res *= i;
            }
        }
        if (n > 1) {
            res *= n;
        }
        return res;
    }
}
```
