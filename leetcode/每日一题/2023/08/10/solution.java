//1289.下降路径最小和 II
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int[][] f = new int[n][n];
        // 初始化首行的路径和
        for (int i = 0; i < n; i++) f[0][i] = arr[0][i];
        // 从第一行进行转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                int val = arr[i][j];
                // 枚举上一行的每个列下标
                for (int p = 0; p < n; p++) {
                    // 只有列下标不同时，才能更新状态
                    if (j != p) {
                        f[i][j] = Math.min(f[i][j], f[i-1][p] + val);
                    }
                }
            }
        }
        // 在所有的 f[n - 1][i] 中取最小值
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n-1][i]);
        }
        return ans;
    }
}