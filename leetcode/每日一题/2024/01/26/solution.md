2846. 边权重均等查询

```java
import java.util.*;

public class Solution {
    private int[][] pa;
    private List<List<Pair>> g;
    private int[][][] cnt;
    private int[] depth;
    
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            g.get(x).add(new Pair(y, w - 1));
            g.get(y).add(new Pair(x, w - 1));
        }

        int m = Integer.toBinaryString(n).length();
        
        pa = new int[n][m];
        for (int[] row : pa) {
            Arrays.fill(row, -1);
        }

        cnt = new int[n][m][26];
        depth = new int[n];

        dfs(0, -1);

        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                if (p != -1) {
                    int pp = pa[p][i];
                    pa[x][i + 1] = pp;
                    for (int j = 0; j < 26; j++) {
                        cnt[x][i + 1][j] = cnt[x][i][j] + cnt[p][i][j];
                    }
                }
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int pathLen = depth[x] + depth[y];

            int[] cw = new int[26];
            if (depth[x] > depth[y]) {
                int temp = x;
                x = y;
                y = temp;
            }

            int k = depth[y] - depth[x];
            for (int j = 0; j < Integer.toBinaryString(k).length(); j++) {
                if (((k >> j) & 1) == 1) {
                    int p = pa[y][j];
                    for (int l = 0; l < 26; l++) {
                        cw[l] += cnt[y][j][l];
                    }
                    y = p;
                }
            }

            if (y != x) {
                for (int j = m - 1; j >= 0; j--) {
                    int px = pa[x][j];
                    int py = pa[y][j];
                    if (px != py) {
                        for (int l = 0; l < 26; l++) {
                            cw[l] += cnt[x][j][l] + cnt[y][j][l];
                        }
                        x = px;
                        y = py;
                    }
                }
                for (int l = 0; l < 26; l++) {
                    cw[l] += cnt[x][0][l] + cnt[y][0][l];
                }
                x = pa[x][0];
            }

            int lca = x;
            pathLen -= depth[lca] * 2;
            int maxCw = Arrays.stream(cw).max().getAsInt();
            ans[i] = pathLen - maxCw;
        }

        return ans;
    }

    class Pair {
        int x;
        int w;

        Pair(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    private void dfs(int x, int fa) {
        pa[x][0] = fa;
        for (Pair pair : g.get(x)) {
            int y = pair.x;
            int w = pair.w;
            if (y != fa) {
                cnt[y][0][w] = 1;
                depth[y] = depth[x] + 1;
                dfs(y, x);
            }
        }
    }
}
```