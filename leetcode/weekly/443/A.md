每次都找到当前位置以及之前位置的最小值即可，因为可以通过与前面的最小值先
交换，然后免费换到当前位置

```java
class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        int min = cost[0];
        for(int i = 0 ; i < n; ++ i) {
            min = Math.min(min, cost[i]);
            ans[i] = min;
        }

        return ans;
    }
}
```