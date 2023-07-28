//2050.并行课程 III
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        var deg = new int[n];
        for (var r : relations) {
            int x = r[0] - 1, y = r[1] - 1;
            g[x].add(y);
            deg[y]++;
        }

        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++)
            if (deg[i] == 0) // 没有先修课
                q.add(i);
        var f = new int[n];
        int ans = 0;
        while (!q.isEmpty()) {
            int x = q.poll(); // x 出队，意味着 x 的所有先修课都上完了
            f[x] += time[x]; // 加上当前课程的时间，就得到了最终的 f[x]
            ans = Math.max(ans, f[x]);
            for (int y : g[x]) { // 遍历 x 的邻居 y
                f[y] = Math.max(f[y], f[x]); // 更新 f[y] 的所有先修课程耗时的最大值
                if (--deg[y] == 0) // y 的先修课已上完
                    q.add(y);
            }
        }
        return ans;
    }
}