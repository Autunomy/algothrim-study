题解请看[灵神题解]()
```java
class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        // 把利润从大到小排序
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long ans = 0, totalProfit = 0;
        var vis = new HashSet<Integer>(); // 已经访问过的类别
        var duplicate = new ArrayDeque<Integer>(); // 重复类别的利润
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0], category = items[i][1];
            if (i < k) {
                totalProfit += profit;
                if (!vis.add(category)) // 重复类别 如果category之前已经在vis中了，就会返回false 此时就需要将重复的利润放入队列中
                    duplicate.push(profit);
            } else if (!duplicate.isEmpty() && vis.add(category)) {//有重复类别，且当前类别不是重复类别
                totalProfit += profit - duplicate.pop(); // 选一个重复类别中的最小利润替换
            } // else：比前面的利润小，而且类别还重复了，选它只会让 totalProfit 变小，vis.size() 不变，优雅度不会变大
            ans = Math.max(ans, totalProfit + (long) vis.size() * vis.size()); // 注意 1e5*1e5 会溢出
        }
        return ans;
    }
}
```