//1444.切披萨的方案数
class Solution {
    public int ways(String[] pizza, int k) {
        final int MOD = (int) 1e9 + 7;
        int m = pizza.length, n = pizza[0].length();
        var sum = new int[m + 1][n + 1]; // 二维后缀和
        var f = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sum[i][j] = sum[i][j + 1] + sum[i + 1][j] - sum[i + 1][j + 1] + (pizza[i].charAt(j) & 1);
                if (sum[i][j] > 0) f[i][j] = 1; // 初始值
            }
        }

        while (--k > 0) {
            var colS = new int[n]; // colS[j] 表示 f 第 j 列的后缀和
            for (int i = m - 1; i >= 0; i--) {
                int rowS = 0; // f[i] 的后缀和
                for (int j = n - 1; j >= 0; j--) {
                    int tmp = f[i][j];
                    if (sum[i][j] == sum[i][j + 1]) // 左边界没有苹果
                        f[i][j] = f[i][j + 1];
                    else if (sum[i][j] == sum[i + 1][j]) // 上边界没有苹果
                        f[i][j] = f[i + 1][j];
                    else // 左边界上边界都有苹果，那么无论怎么切都有苹果
                        f[i][j] = (rowS + colS[j]) % MOD;
                    rowS = (rowS + tmp) % MOD;
                    colS[j] = (colS[j] + tmp) % MOD;
                }
            }
        }
        return f[0][0];
    }
}