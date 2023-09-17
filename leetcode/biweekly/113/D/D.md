[灵神题解](https://leetcode.cn/problems/minimum-edge-reversals-so-every-node-is-reachable/)

```java
class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(new int[]{y, 1});
            g[y].add(new int[]{x, -1}); // 从 y 到 x 需要反向
        }

        var ans = new int[n];
        dfs(0, -1, g, ans);
        reroot(0, -1, g, ans);
        return ans;
    }

    private void dfs(int x, int fa, List<int[]>[] g, int[] ans) {
        for (var e : g[x]) {
            int y = e[0], dir = e[1];
            if (y != fa) {
                if (dir < 0) {
                    ans[0]++;
                }
                dfs(y, x, g, ans);
            }
        }
    }

    private void reroot(int x, int fa, List<int[]>[] g, int[] ans) {
        for (var e : g[x]) {
            int y = e[0], dir = e[1];
            if (y != fa) {
                ans[y] = ans[x] + dir; // dir 就是从 x 换到 y 的「变化量」
                reroot(y, x, g, ans);
            }
        }
    }
}
```