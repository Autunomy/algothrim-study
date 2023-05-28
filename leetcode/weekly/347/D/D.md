思路：使用数据结构优化DP，直接DP会超时，则需要使用一些额外的空间保存重要信息减少时间复杂度。本题就是使用两个数组，分别保存到达每行每列时走过的单元格数量
更新的时候最优策略就是从最小的mat[i][j]走到最大的mat[i][j],由于有可能有重复值，则需要使用一个list来存储每种数字的所有下标

详细题解:[灵神题解](https://leetcode.cn/problems/maximum-strictly-increasing-cells-in-a-matrix/solutions/2286920/dong-tai-gui-hua-you-hua-pythonjavacgo-b-axv0/)

```java
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        //TreeMap会自动按照key排序
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        int n = mat.length;
        int m = mat[0].length;

        //将所有相同的元素的坐标放在一起
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map.computeIfAbsent(mat[i][j],k -> new ArrayList<>()).add(new int[]{i,j});
            }
        }

        int res = 0;
        int[] rowMax = new int[n];//每一行中能走最多的单元格数量
        int[] colMax = new int[m];//每一列中能走最多的单元格数量

        for(List<int[]> val : map.values()){
            int[] temp = new int[val.size()];
            //使用每行每列的最大值更新当前值
            for(int i=0;i<val.size();++i){
                //后面+1表示加上当前值
                temp[i] = Math.max(rowMax[val.get(i)[0]],colMax[val.get(i)[1]]) + 1;
                res = Math.max(res,temp[i]);
            }

            //更新rowMax和colMax
            for(int i=0;i<val.size();++i){
                rowMax[val.get(i)[0]] = Math.max(rowMax[val.get(i)[0]],temp[i]);
                colMax[val.get(i)[1]] = Math.max(colMax[val.get(i)[1]],temp[i]);
            }
        }
        return res;

    }
}
```