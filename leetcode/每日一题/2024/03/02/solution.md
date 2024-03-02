2368. 受限条件下可到达节点的数目

```java
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
        // 邻接表建图
        for (int i = 0; i < n - 1; ++i){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        // 处理restricted数组
        for (int num : restricted) vis[num] = true;
        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        vis[0] = true;
        int ans = 1;
        while (!q.isEmpty()){
            int cur = q.pollFirst();
            for (int next : adj[cur]){
                if (!vis[next]){
                    q.addLast(next);
                    vis[next] = true;
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```