2719. 统计整数数目

```java
class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private int minSum, maxSum;

    public int count(String num1, String num2, int minSum, int maxSum) {
        this.minSum = minSum;
        this.maxSum = maxSum;
        int ans = count(num2) - count(num1) + MOD; // 避免负数
        int sum = 0;
        for (char c : num1.toCharArray()) sum += c - '0';
        if (minSum <= sum && sum <= maxSum) ans++; // x=num1 是合法的，补回来
        return ans % MOD;
    }

    private int count(String S) {
        var s = S.toCharArray();
        int n = s.length;
        var memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return f(s, memo, 0, 0, true);
    }

    private int f(char[] s, int[][] memo, int i, int sum, boolean isLimit) {
        if (sum > maxSum) return 0; // 非法数字
        if (i == s.length) return sum >= minSum ? 1 : 0;
        if (!isLimit && memo[i][sum] != -1) return memo[i][sum];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; ++d) // 枚举要填入的数字 d
            res = (res + f(s, memo, i + 1, sum + d, isLimit && d == up)) % MOD;
        if (!isLimit) memo[i][sum] = res;
        return res;
    }
}
```