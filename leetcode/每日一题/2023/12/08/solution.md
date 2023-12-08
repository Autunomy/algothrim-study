2008. 出租车的最大盈利

```java
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> rideMap = new HashMap<Integer, List<int[]>>();
        for (int[] ride : rides) {
            rideMap.putIfAbsent(ride[1], new ArrayList<int[]>());
            rideMap.get(ride[1]).add(ride);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] ride : rideMap.getOrDefault(i, new ArrayList<int[]>())) {
                dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
        }
        return dp[n];
    }
}
```