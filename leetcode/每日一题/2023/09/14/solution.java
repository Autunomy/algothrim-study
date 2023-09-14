//1222. 可以攻击国王的皇后
class Solution {
    int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
    int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<queens.length;++i){
            set.add(queens[i][0] * 100 + queens[i][1] + "");
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<8;++i){
            for(int j=0;j*dx[i] + king[0] >= 0 && j*dx[i] + king[0] < 8 && j*dy[i] + king[1] >= 0 && j*dy[i] + king[1] < 8;++j){
                int nx = j*dx[i] + king[0];
                int ny = j*dy[i] + king[1];
                if(set.contains(nx * 100 + ny + "")){
                    List<Integer> list = new ArrayList<>();
                    list.add(nx);
                    list.add(ny);
                    res.add(list);
                    break;
                }
            }
        }
        return res;
    }
}