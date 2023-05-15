/*
思路：
题目的意思是经过反转，可以让一行中的所有值都相同，求最多有多少行满足条件。
如果两个行通过相同的反转操作能让每个行内的元素行内元素互相都相等，那么就将其归到同一类
例如
- 000 和 111 这两个是一样的；
- 010 和 101 这两个也是一样的，因为它们可以通过翻转第二列完成相同。
- 110 和 001 也是一样，因为不管是翻转前两列还是翻转最后一列，都会让两行都进入相同的状态。

我们看出，如果两个行是可以通过翻转相同的列达到全行相同，那么就要满足，
两行的相同的位置上的值异或之后等于全1 。 那我们可以根据 异或 操作的特征： a ^ b = c 那么 a ^ c = b

使用一个map，key保存的是行构成的字符串，value表示能编程这个字符串的数量
我们为了方便统计数量规定：如果首位为1，则对每每一位异或1，如果第一位为0，就不进行操作 
最后对map中的每一个value取max

*/
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;++j){
                if(matrix[i][0] == 0){
                    sb.append("" + matrix[i][j]);
                }else{
                    sb.append("" + (matrix[i][j] ^ 1));
                }
            }   

            res = Math.max(res,map.getOrDefault(sb.toString(),0) + 1);
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0) + 1);
        }
        return res;
    }
}