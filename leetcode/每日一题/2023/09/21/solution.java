//2603. 收集树中金币
class Solution {
  public int collectTheCoins(int[] coins, int[][] edges) {
    int n = coins.length;
    Set<Integer>[] nes = new HashSet[n];
    for (int i = 0; i < n; i++) {
      nes[i] = new HashSet<>();
    }
    for (int[] e : edges) {
      nes[e[0]].add(e[1]);
      nes[e[1]].add(e[0]);
    }

    boolean[] deleted = new boolean[n];

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      if (nes[i].size() == 1 && coins[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      deleted[cur] = true;
      for (int ne : nes[cur]) {
        nes[ne].remove(cur);
        if (coins[ne] == 0 && nes[ne].size() == 1) {
          q.add(ne);
        }
      }
    }

    for (int iter = 0; iter < 2; ++iter) {
      for (int i = 0; i < n; ++i) {
        if (!deleted[i] && nes[i].size() == 1) {
          deleted[i] = true;
        }
      }
      for (int i = 0; i < n; ++i) {
        if (deleted[i]) {
          for (int ne : nes[i]) {
            nes[ne].remove(i);
          }
        }
      }
    }

    int res = 0;
    for (int[] e : edges) {
      if (!deleted[e[0]] && !deleted[e[1]]) {
        res += 2;
      }
    }

    return res;
  }
}