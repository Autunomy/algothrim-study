思路：搜索每一个点，每搜索一个点就将其所在的连通分量中的所有点都标记为已遍历，然后判断这个连通分量是否是完全连通分量。由于数据范围很小，直接暴力即可

```java
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        // int n = edges.length;
        
        int[][] g = new int[n][n];
        for(int i=0;i<edges.length;++i){
            g[edges[i][0]][edges[i][1]] = 1;
            g[edges[i][1]][edges[i][0]] = 1;
        }
        
        boolean[] st = new boolean[n];
        
        for(int i=0;i<n;++i){
            if(!st[i]){
                st[i] = true;
                List<Integer> list = new ArrayList<>();
                Queue<Integer> q = new ArrayDeque<>();
                list.add(i);
                q.add(i);
                
                while(q.size() > 0){
                    int len = q.size();
                    
                    while(len -- > 0){
                        int temp = q.poll();
                        for(int j=0;j<n;++j){
                            if(g[temp][j] == 1 && !st[j]){
                                st[j] = true;
                                list.add(j);
                                q.offer(j);
                            }
                        }
                    }
                }
                boolean flag = true;
                for(int k=0;k<list.size();++k){
                    int a = list.get(k);
                    for(int j=k+1;j<list.size();++j){
                        int b = list.get(j);
                        if(g[a][b] != 1){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }
                if(flag)                
                    res ++;
            }
        }
        return res;
        
        
    }
}
```