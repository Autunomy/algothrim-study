思路：暴力模拟即可

```java
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] tl = new int[n][m];
        int[][] br = new int[n][m];
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(i == 0 || j == 0){//只有右下
                    int x = i+1,y = j+1;
                    Set<Integer> set = new HashSet<>();
                    while(x < n && y < m){
                        set.add(grid[x][y]);
                        x++;
                        y++;
                    }
                    br[i][j] = set.size();
                }else if(i == n-1 || j == m-1){//只有左上
                    int x = i-1,y = j-1;
                    Set<Integer> set = new HashSet<>();
                    while(x >= 0 && y >= 0){
                        set.add(grid[x][y]);
                        x--;
                        y--;
                    }
                    tl[i][j] = set.size();
                }else{//右下和左上都有
                    int x = i+1,y = j+1;
                    Set<Integer> set = new HashSet<>();
                    while(x < n && y < m){
                        set.add(grid[x][y]);
                        x++;
                        y++;
                    }
                    br[i][j] = set.size();
                    x = i-1;
                    y = j-1;
                    set = new HashSet<>();
                    while(x >= 0 && y >= 0){
                        set.add(grid[x][y]);
                        x--;
                        y--;
                    }
                    tl[i][j] = set.size();
                }                
            }
        }
        
        int[][] res = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                res[i][j] = Math.abs(tl[i][j] - br[i][j]);
            }
        }
        return res;

    }
}
```