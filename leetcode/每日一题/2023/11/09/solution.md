2258. 逃离火灾

```java
class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int[] res = bfs(grid, List.of(new int[]{0, 0}));
        int manToHouseTime = res[0], m1 = res[1], m2 = res[2];
        if (manToHouseTime < 0) { // 人无法到安全屋
            return -1;
        }

        List<int[]> firePos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    firePos.add(new int[]{i, j});
                }
            }
        }
        res = bfs(grid, firePos); // 多个着火点同时跑 BFS
        int fireToHouseTime = res[0], f1 = res[1], f2 = res[2];
        if (fireToHouseTime < 0) { // 火无法到安全屋
            return 1_000_000_000;
        }

        int d = fireToHouseTime - manToHouseTime;
        if (d < 0) { // 火比人先到安全屋
            return -1;
        }

        if (m1 != -1 && m1 + d < f1 || // 安全屋左边相邻格子，人比火先到
            m2 != -1 && m2 + d < f2) { // 安全屋上边相邻格子，人比火先到
            return d; // 图中第一种情况
        }
        return d - 1; // 图中第二种情况
    }

    // 返回的数组包含三个数，分别表示到达安全屋/安全屋左边/安全屋上边的最短时间
    private int[] bfs(int[][] grid, List<int[]> q) {
        int m = grid.length, n = grid[0].length;
        int[][] time = new int[m][n];
        for (int[] t : time) {
            Arrays.fill(t, -1); // -1 表示未访问
        }
        for (int[] p : q) {
            time[p[0]][p[1]] = 0;
        }
        for (int t = 1; !q.isEmpty(); t++) { // 每次循环向外扩展一圈
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                for (int[] d : DIRS) { // 枚举上下左右四个方向
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 0 && time[x][y] < 0) {
                        time[x][y] = t;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return new int[]{time[m - 1][n - 1], time[m - 1][n - 2], time[m - 2][n - 1]};
    }
}
```