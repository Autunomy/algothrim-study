//1595. 连通两组点的最小成本
class Solution {
    private List<List<Integer>> cost;
    private int[] minCost;
    private int[][] memo;

    public int connectTwoGroups(List<List<Integer>> cost) {
        this.cost = cost;
        int n = cost.size(), m = cost.get(0).size();
        minCost = new int[m];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int j = 0; j < m; j++)
            for (var c : cost)
                minCost[j] = Math.min(minCost[j], c.get(j));

        memo = new int[n][1 << m];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return dfs(n - 1, (1 << m) - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) {
            int res = 0;
            for (int k = 0; k < minCost.length; k++)
                if ((j >> k & 1) == 1) // 第二组的点 k 未连接
                    res += minCost[k]; // 去第一组找个成本最小的点连接
            return res;
        }
        if (memo[i][j] != -1) return memo[i][j]; // 之前算过了
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < minCost.length; k++) // 第一组的点 i 与第二组的点 k
            res = Math.min(res, dfs(i - 1, j & ~(1 << k)) + cost.get(i).get(k));
        return memo[i][j] = res; // 记忆化
    }
}