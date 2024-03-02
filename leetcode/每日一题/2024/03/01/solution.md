2369. 检查数组是否存在有效划分

```java
class Solution {
    int[] dp;
    public boolean validPartition(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,nums.length-1);
    }

    public boolean dfs(int[] nums,int u){
        if(u < 0) return true;
        if(dp[u] > -1) return dp[u] == 1;
        int n = nums.length;
        boolean res = false;
        if(u - 1 >= 0 && nums[u] == nums[u-1]) 
            res = res || dfs(nums,u-2);
        if(u - 2 >= 0 && nums[u] == nums[u-1] && nums[u-1] == nums[u-2]) 
            res = res || dfs(nums,u-3);
        if(u - 2 >= 0 && nums[u] - nums[u-1] == 1 && nums[u-1] - nums[u-2] == 1)
            res = res || dfs(nums,u-3);
        dp[u] = res?1:0;
        return res;
    }
}
```