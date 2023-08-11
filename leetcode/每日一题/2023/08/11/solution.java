//	1572.矩阵对角线元素的和
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;

        int sum = 0;
        for(int i=0;i<n;++i) {
            if(i != n-i-1){
                sum += mat[i][i] + mat[i][n-i-1];
            }else{
                sum += mat[i][i];
            }
        }  
        return sum;
    }
}