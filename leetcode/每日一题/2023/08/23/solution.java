//1782.统计点对的数目
class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        var deg = new int[n + 1];
        var cntE = new HashMap<Integer, Integer>();
        for (var e : edges) {
            int x = e[0], y = e[1];
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            deg[x]++;
            deg[y]++;
            cntE.merge(x << 16 | y, 1, Integer::sum);
        }

        // 统计 deg 中元素的出现次数
        var cntDeg = new HashMap<Integer, Integer>();
        int maxDeg = 0;
        for (int i = 1; i <= n; i++) {
            cntDeg.merge(deg[i], 1, Integer::sum); // cntDeg[deg[i]]++
            maxDeg = Math.max(maxDeg, deg[i]);
        }

        // 2)
        var cnts = new int[maxDeg * 2 + 2];
        for (var e1 : cntDeg.entrySet()) {
            int deg1 = e1.getKey(), c1 = e1.getValue();
            for (var e2 : cntDeg.entrySet()) {
                int deg2 = e2.getKey(), c2 = e2.getValue();
                if (deg1 < deg2)
                    cnts[deg1 + deg2] += c1 * c2;
                else if (deg1 == deg2)
                    cnts[deg1 + deg2] += c1 * (c1 - 1) / 2;
            }
        }

        // 3)
        for (var e : cntE.entrySet()) {
            int k = e.getKey(), c = e.getValue();
            int s = deg[k >> 16] + deg[k & 0xffff];
            cnts[s]--;
            cnts[s - c]++;
        }

        // 4) 计算 cnts 的后缀和
        for (int i = cnts.length - 1; i > 0; i--)
            cnts[i - 1] += cnts[i];

        for (int i = 0; i < queries.length; i++)
            queries[i] = cnts[Math.min(queries[i] + 1, cnts.length - 1)];
        return queries;
    }
}