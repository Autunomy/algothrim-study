53. 最大子数组和

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;++i){
            if(dp[i-1] > 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
```