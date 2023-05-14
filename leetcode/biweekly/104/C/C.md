思路：给一个数乘2就是将一个数的二进制左移一位。这道题利用了贪心的思想，将k全部给一个数乘2是最优的选择
保存一个后缀和或 suf[i] 表示 nums[i] | nums[i+1] | ... | nums[n-1]
保存一个pre表示nums[0] | nums[1] | ... | nums[i-1]
每次给当前值左移k位后 | pre | suf[i+1] 用过这个值更新答案

```java
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n+1];
        //其实这里i枚举到1就可以了 因为后面算答案的时候是从0开始的 不需要suf[0]这个值
        for(int i=n-1;i>=0;--i){
            suf[i] = suf[i+1] | nums[i];
        }
        int pre = 0;
        long ans = 0;
        for(int i=0;i<n;++i){
            ans = Math.max(ans,pre | ((long)nums[i]<<k) | suf[i+1]);
            pre |= nums[i];
        }
        return ans;
    }
}
```