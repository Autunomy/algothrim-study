同类型题目视频讲解：[https://www.bilibili.com/video/BV1rS4y1s721?share_source=copy_web](https://www.bilibili.com/video/BV1rS4y1s721?share_source=copy_web)直接查看T4即可

```java
//数位dp模板
class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return calc(high, k) - calc(low - 1, k);
    }

    private int calc(int high, int k) {
        var s = Integer.toString(high).toCharArray();
        int n = s.length;
        var memo = new int[n][k][n * 2 + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                Arrays.fill(memo[i][j], -1); // -1 表示没有计算过
        return dfs(0, 0, n, true, false, k, s, memo);
    }

    private int dfs(int i, int val, int diff, boolean isLimit, boolean isNum, int k, char[] s, int[][][] memo) {
        if (i == s.length)
            return isNum && val == 0 && diff == s.length ? 1 : 0; // 找到了一个合法数字
        if (!isLimit && isNum && memo[i][val][diff] != -1)
            return memo[i][val][diff];
        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = dfs(i + 1, val, diff, false, false, k, s, memo);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 high 的一样，那么这一位至多填数字 s[i]（否则就超过 high 啦）
        for (int d = isNum ? 0 : 1; d <= up; d++) // 枚举要填入的数字 d
            res += dfs(i + 1, (val * 10 + d) % k, diff + d % 2 * 2 - 1, isLimit && d == up, true, k, s, memo);
        if (!isLimit && isNum)
            memo[i][val][diff] = res; // 记忆化搜索
        return res;
    }
}
```