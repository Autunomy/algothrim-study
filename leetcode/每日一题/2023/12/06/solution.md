2646. 最小化旅行的价格总和

```java
class Solution {
    Map<Integer, List<Integer>> map;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        map = new HashMap<>();
        for(int i=0;i<n;++i){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int[] cnt = new int[n];
        for(int[] trip : trips){
            dfs1(trip[0],-1,cnt,trip[1]);
        }
        int[] arr = dfs2(0,-1,price,cnt);
        return Math.min(arr[0],arr[1]);
    }
    
    //统计每个点可能被经过的次数
    public boolean dfs1(int x,int fa,int[] cnt,int end){
        if(x == end){
            cnt[x] ++;
            return true; 
        }
        
        for(int i : map.get(x)){
            if(i != fa && dfs1(i,x,cnt,end)){
                cnt[x] ++;
                return true;
            }
        }
        return false;
    }
    
    public int[] dfs2(int x,int fa,int[] price,int[] cnt){
        int notHalf = cnt[x] * price[x];
        int half = notHalf / 2;
        
        for(int i : map.get(x)){
            if(i != fa){
                int[] temp = dfs2(i,x,price,cnt);
                notHalf += Math.min(temp[0],temp[1]);//
                half += temp[0];
            }
        }
        return new int[]{notHalf,half};
    }
}
```