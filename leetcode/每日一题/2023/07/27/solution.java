//2500.删除每行中的最大值
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;++i){
            Arrays.sort(grid[i]);
        }
        for(int j=grid[0].length-1;j>=0;--j){
            int max = -1;
            for(int i=0;i<grid.length;++i){
                max = Math.max(max,grid[i][j]);
            }      
            res += max;
        }

        return res;
    }
}