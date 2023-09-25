[题解地址](https://blog.nowcoder.net/n/306a479d23bc479eabd474fb85e6fd4f)

```java
import java.io.*;
import java.util.*;

public class Main {

    static long ksm(long b, long v, long mod) {
        long r = 1l;
        while (v > 0) {
            if (v % 2 == 1) {
                r = r * b % mod;
            }
            b = b * b % mod;
            v /= 2;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt(), m = sc.nextInt();

        List<Integer>[]g = new List[n + 1];
        Arrays.setAll(g, x -> new ArrayList<>());

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);

            edges[i][0] = u;
            edges[i][1] = v;
        }

        long inf = Long.MAX_VALUE / 10;
        long[] cost = new long[n + 1];
        Arrays.fill(cost, inf);

        // BFS求最短路
        Deque<Integer> deq = new ArrayDeque<>();
        deq.offer(1);
        cost[0] = cost[1] = 0;
        while (!deq.isEmpty()) {
            int cur = deq.poll();
            for (int v : g[cur]) {
                if (cost[v] > cost[cur] + 1) {
                    cost[v] = cost[cur] + 1;
                    deq.offer(v);
                }
            }
        }

        // 乘法原理阶段
        long mod = 10_0000_0007l;
        long res = 1l;
        int edgeOfShort = 0; // 参与最短路的边
        // 从2开始计算，忽略节点2
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int v: g[i]) {
                // 保证上流节点
                if (cost[i] == cost[v] + 1) {
                    cnt++;
                }
            }
            edgeOfShort += cnt;

            // 2^z - 1
            long r = ksm(2l, cnt, mod);
            r = ((r - 1) % mod + mod) % mod;

            // 乘法原理
            res = res * r % mod;
        }

        int edgeOfNone = m - edgeOfShort; // 不参与最短路的边数
        res = res * ksm(2l, edgeOfNone, mod) % mod;

        long minCost = Arrays.stream(cost).sum() % mod;
        System.out.println(minCost + " " + res);

    }

}
```