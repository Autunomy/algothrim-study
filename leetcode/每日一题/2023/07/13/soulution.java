//931. 下降路径最小和
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=1;i<n;++i){
            for(int j=0;j<m;++j){
                int temp = Integer.MAX_VALUE;
                if(j-1 >= 0) {
                    temp = Math.min(matrix[i-1][j-1],temp);
                }
                if(j+1<m){
                    temp = Math.min(matrix[i-1][j+1],temp);
                }
                temp = Math.min(matrix[i-1][j],temp);
                matrix[i][j] += temp;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<m;++i){
            res = Math.min(res,matrix[n-1][i]);
        }
        return res;
    }
}