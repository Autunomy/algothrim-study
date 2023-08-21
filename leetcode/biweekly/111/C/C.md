```java
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int ans = 1, n = nums.size();
        // 看透本质: 将一个数组转为单调递增序列的最少操作次数
        // 本质: 不动原本的最长单调递增序列, 去修改剩下的元素, 即是最少操作次数
        // 即ans = n - 最长单调递增子序列长度

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 求最长单调递增子序列
        for(int i=1; i < n; i++){
            for(int j=0; j < i; j++){
                if(nums.get(i) >= nums.get(j)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return n - ans;
    }
}
```