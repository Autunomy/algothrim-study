2684. 矩阵中移动的最大次数

```java
class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        int[][] arr = new int[n+1][m+1];
        for(int i=0;i<=n;++i) arr[i][0] = Integer.MAX_VALUE;
        for(int i=0;i<=m;++i) arr[0][i] = Integer.MAX_VALUE;
        
        
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                arr[i][j] = grid[i-1][j-1];
            }
        }
        int step = -1;
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=1;i<=n;++i) q.offer(new int[]{i,1});
        Set<String> s = new HashSet<>();
        while(q.size() > 0){
            step++;
            int len = q.size();
            while(len -- > 0){
                int[] temp = q.poll();
                int a = temp[0];
                int b = temp[1];
                if(b == m) return m-1;
                if(a - 1 >= 1 && arr[a-1][b+1] > arr[a][b] && !s.contains("" + (a-1) + (b+1))) {
                    q.offer(new int[]{a-1,b+1});
                    s.add("" + (a-1) + (b+1));
                }
                if(arr[a][b+1] > arr[a][b]  && !s.contains("" + (a) + (b+1))) {
                    q.offer(new int[]{a,b+1});
                    s.add("" + (a) + (b+1));
                }
                if(a + 1<=n && arr[a+1][b+1] > arr[a][b]  && !s.contains("" + (a+1) + (b+1))) {
                    q.offer(new int[]{a+1,b+1});
                    s.add("" + (a+1) + (b+1));
                }
                
            }
        }
        
        return step;
        
    }
    
}
```