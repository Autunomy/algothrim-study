class Solution {
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (land[i][j] == 0) // 从没有访问过的 0 出发
                    ans.add(dfs(land, i, j));

        // 简洁写法，但是慢
        // return ans.stream().sorted().mapToInt(i -> i).toArray();

        // 更快的写法
        var size = new int[ans.size()];
        int i = 0;
        for (int x : ans)
            size[i++] = x;
        Arrays.sort(size);
        return size;
    }

    private int dfs(int[][] land, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[x].length || land[x][y] != 0)
            return 0;
        land[x][y] = 1; // 标记 (x,y) 被访问，避免重复访问
        int cnt0 = 1;
        // 访问八方向的 0
        for (int i = x - 1; i <= x + 1; i++)
            for (int j = y - 1; j <= y + 1; j++)
                cnt0 += dfs(land, i, j);
        return cnt0;
    }
}