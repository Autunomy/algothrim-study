思路：数学题需要推导公式，详细可看[灵神题解](https://leetcode.cn/problems/power-of-heroes/solutions/2268792/gong-xian-fa-pythonjavacgo-by-endlessche-d4jx/)
小技巧：可以先全部使用long来计算，最后强制转换为int即可

```java
class Solution {
    public int sumOfPower(int[] nums) {
        long mod = 1000000007;
        Arrays.sort(nums);
        long s = 0,res = 0;
        for(int i=0;i<nums.length;++i){
            res = (res + (long)nums[i] * nums[i]  % mod * (nums[i] + s) % mod)%mod;
            s = (s * 2 + nums[i])%mod;
        }
        return (int)res;
    }
}
```