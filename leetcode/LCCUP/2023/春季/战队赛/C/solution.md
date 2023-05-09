原题链接:[https://leetcode.cn/problems/kjpLFZ/](https://leetcode.cn/problems/kjpLFZ/)

思路:BFS找最小路径,具体细节看注释

```java
class Solution {
    int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int extractMantra(String[] matrix, String mantra) {
        int n = matrix.length;
        int m = matrix[0].length();

        //记录状态
        boolean[][][] s = new boolean[n][m][mantra.length()];
        //队列
        Queue<int[]> q = new ArrayDeque();

        //初始状态在左上角，且已经提取出来的字符数量为0
        q.add(new int[]{0,0,0});
        
        //初始的步数
        int step = 1;
        while(q.size() > 0){
            int sz = q.size();

            while(sz -- > 0){
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                int k = arr[2];
                //如果当前的字符等于对应的mentra中的字符
                if(matrix[i].charAt(j) == mantra.charAt(k)){
                    if(k == mantra.length() - 1){//如果恰好是最好一个字符匹配到了，直接返回即可
                        return step;
                    }
                    //不是最后一个字符 那就将当前字符提取出来
                    int[] p = new int[]{i,j,k+1};
                    //如果之前没有遍历过这个状态 就加入到队列中
                    if(!s[i][j][k+1]){
                        q.offer(p);
                        s[i][j][k+1] = true;
                    }
                }
                //向上下左右四个方向走
                for(int z=0;z<4;++z){
                    int newi = i + pos[z][0];
                    int newj = j + pos[z][1];
                    if(newi >= 0 && newi < n && newj >= 0 && newj < m && !s[newi][newj][k]){
                        s[newi][newj][k] = true;
                        q.offer(new int[]{newi,newj,k});
                    }
                }
            }
            step ++;
        }
        return -1;
    } 
}
```