928. 尽量减少恶意软件的传播 II

```java
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] initialSet = new boolean[n];
        for (int v : initial) {
            initialSet[v] = true;
        }
        List<Integer>[] infectedBy = new List[n];
        for (int i = 0; i < n; i++) {
            infectedBy[i] = new ArrayList<Integer>();
        }
        for (int v : initial) {
            boolean[] infectedSet = new boolean[n];
            dfs(graph, initialSet, infectedSet, v);
            for (int u = 0; u < n; u++) {
                if (infectedSet[u]) {
                    infectedBy[u].add(v);
                }
            }
        }
        int[] count = new int[n];
        for (int u = 0; u < n; u++) {
            if (infectedBy[u].size() == 1) {
                count[infectedBy[u].get(0)]++;
            }
        }
        int res = initial[0];
        for (int v : initial) {
            if (count[v] > count[res] || count[v] == count[res] && v < res) {
                res = v;
            }
        }
        return res;
    }

    public void dfs(int[][] graph, boolean[] initialSet, boolean[] infectedSet, int v) {
        int n = graph.length;
        for (int u = 0; u < n; u++) {
            if (graph[v][u] == 0 || initialSet[u] || infectedSet[u]) {
                continue;
            }
            infectedSet[u] = true;
            dfs(graph, initialSet, infectedSet, u);
        }
    }
}
```