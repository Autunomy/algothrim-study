/*
    BFS模板
*/
class Solution {
    int[][] pos8 = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        if(n == 1) return 1;

        int step = 1;
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0});
        boolean[][] st = new boolean[n][n];
        st[0][0] = true;
        while(q.size() > 0){
            int len = q.size();

            while(len -- > 0){
                int[] temp = q.poll();
                for(int i=0;i<8;++i){
                    int x = temp[0] + pos8[i][0];
                    int y = temp[1] + pos8[i][1];
                    if(x == n-1 && y == n-1){
                        return step + 1;
                    }
                    if(x >= 0 && x < n && y >=0 && y < n && !st[x][y] && grid[x][y] == 0){
                        q.offer(new int[]{x,y});
                        st[x][y] = true;
                    }
                }
            }
            step ++;
        }
        return -1;
    }
}