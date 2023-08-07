题解请看[灵神题解](https://leetcode.cn/problems/find-the-safest-path-in-a-grid/solutions/2375565/jie-jin-on2-de-zuo-fa-duo-yuan-bfsdao-xu-r5um/)
```java
/** 
方法一
二分答案
找到每次判断一个mid是否存着这个路径 使得mid就是路径中的最小值
判断方式就是将最小距离小于mid的格子都标记为不可以走，然后最后判断是否有通路

方法二
将每个点到1的距离都标注出来 从大到小枚举距离 建立并查集，如果起点和终点在一个并查集的时候就找到了答案
*/
class Solution {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        var q = new ArrayList<int[]>();
        var dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) > 0) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        var groups = new ArrayList<List<int[]>>();
        groups.add(q);
        while (!q.isEmpty()) { // 多源 BFS
            var tmp = q;
            q = new ArrayList<>();
            for (var p : tmp) {
                for (var d : DIRS) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] < 0) {
                        q.add(new int[]{x, y});
                        dis[x][y] = groups.size();
                    }
                }
            }
            groups.add(q); // 相同 dis 分组记录
        }

        // 并查集
        fa = new int[n * n];
        for (int i = 0; i < n * n; i++)
            fa[i] = i;

        for (int ans = groups.size() - 2; ans > 0; ans--) {
            var g = groups.get(ans);
            for (var p : groups.get(ans)) {
                int i = p[0], j = p[1];
                for (var d : DIRS) {
                    int x = i + d[0], y = j + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] >= dis[i][j])
                        fa[find(x * n + y)] = find(i * n + j);
                }
            }
            if (find(0) == find(n * n - 1)) // 写这里判断更快些
                return ans;
        }
        return 0;
    }

    // 并查集模板
    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}
```