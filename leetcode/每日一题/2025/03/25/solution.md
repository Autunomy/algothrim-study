2711. 对角线上不同值的数量差

```java
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];

        for(int i = 0; i < n; ++ i){
            for(int j = 0 ; j < m; ++ j) {
                res[i][j] = Math.abs(left(grid, i, j, n, m) - right(grid, i, j, n, m));
            }
        }

        return res;
    }

    public int left(int[][] grid, int x, int y,int n, int m) {
        Set<Integer> set = new HashSet<>();

        for(int i = x-1, j = y - 1; i>=0 && j >= 0; i -- ,j --) {
            set.add(grid[i][j]);
        }

        return set.size();
    }

    public int right(int[][] grid, int x, int y,int n, int m) {
        Set<Integer> set = new HashSet<>();

        for(int i = x+1, j = y + 1; i<n && j <m; i ++ ,j ++) {
            set.add(grid[i][j]);
        }

        return set.size();
    }
}
```