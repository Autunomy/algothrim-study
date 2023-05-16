//题解请看：https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/solutions/2271631/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-68nx/
class Solution {
    public int minDifficulty(int[] a, int d) {
        int n = a.length;
        if (n < d) return -1;

        var f = new int[n];
        f[0] = a[0];
        for (int i = 1; i < n; i++)
            f[i] = Math.max(f[i - 1], a[i]);
        for (int i = 1; i < d; i++) {
            for (int j = n - 1; j >= i; j--) {
                f[j] = Integer.MAX_VALUE;
                int mx = 0;
                for (int k = j; k >= i; k--) {
                    mx = Math.max(mx, a[k]); // 从 a[k] 到 a[j] 的最大值
                    f[j] = Math.min(f[j], f[k - 1] + mx);
                }
            }
        }
        return f[n - 1];
    }
}
