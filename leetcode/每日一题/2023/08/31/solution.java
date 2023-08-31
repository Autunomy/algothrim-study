//1761. 一个图中连通三元组的最小度数
/*
暴力做法
使用邻接矩阵存储，遍历全部的点并且在遍历的过程中判断每个点所连接的点形成的三元组的连通三元组的度数求最小值
*/
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] g = new int[n+1][n+1];//邻接矩阵
        Map<Integer,Integer> map = new HashMap<>();//存储每个点连接的节点个数，方便统计连通三元组的度数
        for(int i=0;i<edges.length;++i){//建图
            int a = edges[i][0];
            int b = edges[i][1];
            g[a][b] = 1;
            g[b][a] = 1;

            map.put(a,map.getOrDefault(a,0) + 1);
            map.put(b,map.getOrDefault(b,0) + 1);
        }
        //最终答案
        int res = Integer.MAX_VALUE;
        //三元组的数量
        int cnt3 = 0;
        //三重循环找三元组
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                //i与j之间需要有边
                if(j != i && g[i][j] != 0){
                    for(int k = 1;k <= n; ++ k){
                        //k与i之间，j与k之间都需要有边此时就形成了三元组
                        if(k != i && k != j && g[i][k] != 0 && g[j][k] != 0){
                            cnt3++;
                            int temp =  map.get(i) + map.get(j) + map.get(k) - 6;//统计连通三元组的度数
                            res = Math.min(res,temp);
                        }
                    }
                }
            }
        }
        if(cnt3 == 0) return -1;

        return res;
    }
}