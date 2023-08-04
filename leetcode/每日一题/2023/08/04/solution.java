//980.不同路径 III
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cnt0 = 0, sx = -1, sy = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) cnt0++;
                else if (grid[i][j] == 1) { // 起点
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, cnt0 + 1); // +1 把起点也算上
    }

    private int dfs(int[][] grid, int x, int y, int left) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0)
            return 0; // 不合法
        if (grid[x][y] == 2) // 到达终点
            return left == 0 ? 1 : 0; // 必须访问所有的无障碍方格
        grid[x][y] = -1; // 标记成访问过，因为题目要求「不能重复通过同一个方格」
        int ans = dfs(grid, x - 1, y, left - 1) + dfs(grid, x, y - 1, left - 1) +
                  dfs(grid, x + 1, y, left - 1) + dfs(grid, x, y + 1, left - 1);
        grid[x][y] = 0; // 恢复现场
        return ans;
    }
}