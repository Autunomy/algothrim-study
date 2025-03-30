2360. 图中的最长环

题解：https://leetcode.cn/problems/longest-cycle-in-a-graph/solutions/1710828/nei-xiang-ji-huan-shu-zhao-huan-li-yong-pmqmr/?envType=daily-question&envId=2025-03-29

```java
class Solution {
    public int longestCycle(int[] edges) {
        int res = -1;
    
        int n = edges.length;
        int[] vis = new int[n];
        int time = 0;

        for(int i = 0 ; i < n ; ++ i) {

            int val = i;
            int startTime = time;
            while(edges[val] != -1 && vis[val] == 0) {
                vis[val] = time ++;
                val = edges[val];
            }

            if(edges[val] != -1 && vis[val] >= startTime) {
                res = Math.max(res, time - vis[val]);
            }

        }

        return res;
    }
}
```