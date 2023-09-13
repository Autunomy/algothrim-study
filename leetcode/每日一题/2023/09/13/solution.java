//2596. 检查骑士巡视方案
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Map<Integer,int[]> map = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map.put(grid[i][j],new int[]{i,j});
            }
        }
        if(grid[0][0] != 0)return false;
        int[] last = map.get(0);
        for(int i=1;i<n * m;++i){
            int[] arr = map.get(i);
            if( (Math.abs(arr[0] - last[0]) == 2 && Math.abs(arr[1] - last[1]) == 1) || 
                (Math.abs(arr[0] - last[0]) == 1 && Math.abs(arr[1] - last[1]) == 2)){
                    last = arr;
            }else return false;
        }

        return true;
    }
}