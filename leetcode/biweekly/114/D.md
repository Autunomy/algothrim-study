重要性质：整个树的和是k的倍数那么子树只需要一个是k的倍数那么另一个一定是k的倍数
任意选一个起点开始遍历树，判断所有子树的和，如果是k的倍数就给答案+1


```java
class Solution {
    int[] values;
    List<Integer>[] g;
    int res = 0;
    int k;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        g = new ArrayList[n];
        this.values = values;
        this.k = k;

        for(int i=0;i<n;++i) g[i] = new ArrayList<>();

        for(int i=0;i<edges.length;++i){
            int u = edges[i][0];
            int v = edges[i][1];
            g[u].add(v);
            g[v].add(u);
        }

        dfs(-1,0);

        return res;
    }

    long dfs(int fa,int x){
        long sum = values[x];
        for(int i=0;i<g[x].size();++i){
            if(g[x].get(i) != fa){
                sum += dfs(x,g[x].get(i));
            }
        }
        
        if(sum % k == 0) res ++;

        return sum;
    }
}
```