//暴力解法，记录上一层及之前的层中前k小的和，将当前层所有数分别加上之前的所有和，再取前k个，最后返回第k个和
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> list = new ArrayList<>();

        list.add(0);

        for(int i=0;i<mat.length;++i){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<mat[0].length;++j){
                for(int x : list){
                    temp.add(x + mat[i][j]);
                }
            }
            Collections.sort(temp);
            list = new ArrayList<>();
            for(int j=0;j<k && j < temp.size();++j){
                list.add(temp.get(j));
            }
        }

        return list.get(k-1);
    }
}