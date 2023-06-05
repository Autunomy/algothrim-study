class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;++i){
            String str = "";
            for(int j=0;j<m;++j){
                str += grid[i][j] + ",";
            }
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        int res = 0;
        for(int i=0;i<m;++i){
            String str = "";
            for(int j=0;j<n;++j){
                str += grid[j][i] + ",";
            }
            if(map.get(str) != null) res += map.get(str);
        }
        return res;
    }
}