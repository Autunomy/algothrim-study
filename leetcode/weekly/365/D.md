[灵神题解](https://leetcode.cn/problems/count-visited-nodes-in-a-directed-graph/solutions/2464852/nei-xiang-ji-huan-shu-pythonjavacgo-by-e-zrzh/)

```java
class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int[] g = edges.stream().mapToInt(i -> i).toArray();
        int n = g.length;
        List<Integer>[] rg = new ArrayList[n]; // 反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int x = 0; x < n; x++) {
            int y = g[x];
            rg[y].add(x);
            deg[y]++;
        }

        // 拓扑排序，剪掉 g 上的所有树枝
        // 拓扑排序后，deg 值为 1 的点必定在基环上，为 0 的点必定在树枝上
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = g[x];
            if (--deg[y] == 0) {
                q.add(y);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (deg[i] <= 0) {
                continue;
            }
            var ring = new ArrayList<Integer>();
            for (int x = i; ; x = g[x]) {
                deg[x] = -1; // 将基环上的点的入度标记为 -1，避免重复访问
                ring.add(x); // 收集在基环上的点
                if (g[x] == i) {
                    break;
                }
            }
            for (int r : ring) {
                rdfs(r, ring.size(), rg, deg, ans); // 为方便计算，以 ring.size() 作为初始深度
            }
        }
        return ans;
    }

    // 在反图上遍历树枝
    private void rdfs(int x, int depth, List<Integer>[] rg, int[] deg, int[] ans) {
        ans[x] = depth;
        for (int y : rg[x]) {
            if (deg[y] == 0) { // 树枝上的点在拓扑排序后，入度均为 0
                rdfs(y, depth + 1, rg, deg, ans);
            }
        }
    }
}
```