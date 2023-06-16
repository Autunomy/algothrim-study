//1494. 并行课程 II
class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] need = new int[1 << n];
        for (int[] edge : relations) {
            need[(1 << (edge[1] - 1))] |= 1 << (edge[0] - 1);
        }
        dp[0] = 0;
        for (int i = 1; i < (1 << n); ++i) {
            need[i] = need[i & (i - 1)] | need[i & (-i)];
            if ((need[i] | i) != i) { // i 中有任意一门课程的前置课程没有完成学习
                continue;
            }
            int valid = i ^ need[i]; // 当前学期可以进行学习的课程集合
            if (Integer.bitCount(valid) <= k) { // 如果个数小于 k，则可以全部学习，不再枚举子集
                dp[i] = Math.min(dp[i], dp[i ^ valid] + 1);
            } else { // 否则枚举当前学期需要进行学习的课程集合
                for (int sub = valid; sub > 0; sub = (sub - 1) & valid) {
                    if (Integer.bitCount(sub) <= k) {
                        dp[i] = Math.min(dp[i], dp[i ^ sub] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}