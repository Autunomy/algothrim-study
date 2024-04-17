924. 尽量减少恶意软件的传播

```java
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] ids = new int[n];
        Map<Integer, Integer> idToSize = new HashMap<Integer, Integer>();
        int id = 0;
        for (int i = 0; i < n; ++i) {
            if (ids[i] == 0) {
                ++id;
                int size = 1;
                Queue<Integer> queue = new ArrayDeque<Integer>();
                queue.offer(i);
                ids[i] = id;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v = 0; v < n; ++v) {
                        if (ids[v] == 0 && graph[u][v] == 1) {
                            ++size;
                            queue.offer(v);
                            ids[v] = id;
                        }
                    }
                }
                idToSize.put(id, size);
            }
        }
        Map<Integer, Integer> idToInitials = new HashMap<Integer, Integer>();
        for (int u : initial) {
            idToInitials.put(ids[u], idToInitials.getOrDefault(ids[u], 0) + 1);
        }
        int ans = n + 1, ansRemoved = 0;
        for (int u : initial) {
            int removed = (idToInitials.get(ids[u]) == 1 ? idToSize.get(ids[u]) : 0);
            if (removed > ansRemoved || (removed == ansRemoved && u < ans)) {
                ans = u;
                ansRemoved = removed;
            }
        }
        return ans;
    }
}
```