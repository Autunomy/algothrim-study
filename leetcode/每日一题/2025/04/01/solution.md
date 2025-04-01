2140. 解决智力问题

dp求解，从后往前遍历
```java
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        long[] dp = new long[n + 1];

        for(int i = n - 1; i >= 0; -- i) {
            int val = Math.min(n, i + questions[i][1] + 1);
            dp[i] = Math.max(dp[i + 1], dp[val] + questions[i][0]);
        }

        return dp[0];
    }
}
```