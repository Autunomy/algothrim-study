1766. 互质树

```java
class Solution {
    List<Integer>[] gcds;
    List<Integer>[] tmp;
    List<Integer>[] g;
    int[] dep;
    int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        
        // 初始化
        gcds = new List[51];
        tmp = new List[51];
        for (int i = 0; i <= 50; i++) {
            gcds[i] = new ArrayList<Integer>();
            tmp[i] = new ArrayList<Integer>();
        }
        ans = new int[n];
        dep = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(dep, -1);
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    gcds[i].add(j);
                } 
            }
        }

        for (int[] val : edges) {
            g[val[0]].add(val[1]);
            g[val[1]].add(val[0]);
        }

        dfs(nums, 0, 1);
        
        return ans;
    }

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }

    public void dfs(int[] nums, int x, int depth) {
        dep[x] = depth;
        for (int val : gcds[nums[x]]) {
            if (tmp[val].isEmpty()) {
                continue;
            }
        
            int las = tmp[val].get(tmp[val].size() - 1);
            if (ans[x] == -1 || dep[las] > dep[ans[x]]) {
                ans[x] = las;
            }
        }
        tmp[nums[x]].add(x);

        for (int val : g[x]) {
            if (dep[val] == -1) { // 被访问过的点dep不为-1
                dfs(nums, val, depth + 1);
            }
        }

        tmp[nums[x]].remove(tmp[nums[x]].size() - 1);
    }
}
```