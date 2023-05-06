# A-[java]简单模拟

```java
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;++i){
            if(nums[i] > max) max = nums[i];
        }
        int sum = 0;
        for(int i=0;i<k;++i){
            sum += max;
            max++;
        }
        return sum;
    }
}
```

# B-[java]简单模拟

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] res = new int[n];
        int[] cnt1 = new int[60];
        int[] cnt2 = new int[60];
        res[n-1] = n;
        for(int i=0;i<n;++i){
            cnt1[a[i]] ++;
            cnt2[b[i]] ++;
            int cnt = 0;
            for(int j=0;j<60;++j){
                if(cnt1[j] == cnt2[j] && cnt1[j] != 0) cnt ++;
            }
            res[i] = cnt;

        }
        return res;
        
    }
}
```

# C-[java]计数+简单模拟

```java
class Solution {
    int n,m;
    int[] x = new int[]{0,1,0,-1};
    int[] y = new int[]{1,0,-1,0};
    public int findMaxFish(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
        
        int res = 0;
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                res = Math.max(res,bfs(grid,i,j,new boolean[n][m]));
            }
        }
        return res;
    }
    
    public int bfs(int[][] grid,int r,int c,boolean[][] st){
        if(r < 0 || r >= n || c < 0 || c >= m) return 0;
        if(grid[r][c] == 0) return 0;
        if(st[r][c]) return 0;
        int sum = grid[r][c];
        for(int i=0;i<4;++i){
            st[r][c] = true;
            sum += bfs(grid,r+x[i],c+y[i],st);
        }
        return sum;
    }
}
```

# D-[java]暴力+BFS

```java
class Solution {
    int n,m;
    int[] x = new int[]{0,1,0,-1};
    int[] y = new int[]{1,0,-1,0};
    public int findMaxFish(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
        
        int res = 0;
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                res = Math.max(res,bfs(grid,i,j,new boolean[n][m]));
            }
        }
        return res;
    }
    
    public int bfs(int[][] grid,int r,int c,boolean[][] st){
        if(r < 0 || r >= n || c < 0 || c >= m) return 0;
        if(grid[r][c] == 0) return 0;
        if(st[r][c]) return 0;
        int sum = grid[r][c];
        for(int i=0;i<4;++i){
            st[r][c] = true;
            sum += bfs(grid,r+x[i],c+y[i],st);
        }
        return sum;
    }
}
```