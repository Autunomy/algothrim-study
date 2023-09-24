[灵神题解](https://www.bilibili.com/video/BV1yu4y1z7sE/?spm_id_from=top_right_bar_window_dynamic.content.click&vd_source=734e69f10219139821e38611a49c3e88)

思路:枚举所有质数节点，并统计质数连接的所有连通块的大小，每个质数可以产生的路径数量就可以通过连通块大小之间的组合来计算。但是中间统计连通块大小的时候需要进行记忆化，防止极端情况(一个非质数节点连接所有质数节点)的发生。

```java
class Solution {

    boolean[] zhi = new boolean[100010];//质数是false 合数是true
    public long countPaths(int n, int[][] edges) {
        //预处理100000内的质数
        zhi[1] = true;
        for(int i=2;i * i<zhi.length;++i){
            if(!zhi[i]){
                for(int j=i*i;j<zhi.length;j+=i){
                    zhi[j] = true;
                }
            }
        }

        long res = 0;
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g,e -> new ArrayList<>());

        for(int i=0;i<edges.length;++i){
            int u = edges[i][0];
            int v = edges[i][1];

            g[u].add(v);
            g[v].add(u);
        }

        int[] nums = new int[n + 1];//存储每个点所在连通块的大小
        //遍历所有的节点
        for(int i=1;i<=n;++i){
            if(zhi[i]){//跳过非质数
                continue;
            }
            
            List<Integer> path = new ArrayList<>();
            long sum = 0;

            for(Integer val : g[i]){
                if(!zhi[val]){//必须是非质数
                    continue;
                }
                if(nums[val] == 0){//没有计算过
                    path.clear();
                    dfs(val,-1,g,path);

                    for(Integer y : path){
                        nums[y] = path.size();
                    }
                }
                //这里的理解是：因为a->b和b->a只算一个 所以假设有 x y z三个连通块大小，那么通路数量就是 x * y + (x + y) * z  可以将和的部分保存为sum，方便每次操作
                res += sum * nums[val];
                sum += nums[val];
            }
            //前面计算的都是经过质数点i，这里加的是直接从i出发的路径数量
            res += sum;
        }
        return res;
    }

    void dfs(int node,int fa,List<Integer>[] g,List<Integer> path){
        path.add(node);
        for(Integer val : g[node]){
            if(val != fa && zhi[val]){
                dfs(val,node,g,path);
            }
        }
    }
}
```