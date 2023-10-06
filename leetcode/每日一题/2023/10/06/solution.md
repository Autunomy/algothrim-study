714. 买卖股票的最佳时机含手续费

[灵神题解](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/2469505/shi-pin-gu-piao-mai-mai-tong-yong-fang-f-0u38/?envType=daily-question&envId=2023-10-06)
```java
class Solution {
    private int[] prices;
    private int[][] memo;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        int n = prices.length;
        memo = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        return dfs(n - 1, 0);
    }

    private int dfs(int i, int hold) {
        if (i < 0) return hold == 1 ? Integer.MIN_VALUE / 2 : 0; // 防止溢出
        if (memo[i][hold] != -1) return memo[i][hold]; // 之前计算过
        if (hold == 1)
            return memo[i][hold] = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - prices[i]);
        return memo[i][hold] = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i] - fee);
    }
}
```