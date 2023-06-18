class Solution {
    int n;
    int m;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int[][] grid,int x,int y){
        if(x<0||x>=n||y<0||y>=m||grid[x][y]==1) return;
        grid[x][y]=1;
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0) dfs(grid,i,0);
            if(grid[i][m-1]==0) dfs(grid,i,m-1);
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==0) dfs(grid,0,j);
            if(grid[n-1][j]==0) dfs(grid,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) continue;
                dfs(grid,i,j);
                ans++;
            }
        }
        return ans;
    }
}