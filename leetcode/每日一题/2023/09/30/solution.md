2136. 全部开花的最早一天
[灵神题解](https://leetcode.cn/problems/earliest-possible-day-of-full-bloom/?envType=daily-question&envId=2023-09-30)

```java
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        var id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
        int ans = 0, days = 0;
        for (int i : id) {
            days += plantTime[i]; // 累加生长天数
            ans = Math.max(ans, days + growTime[i]); // 更新最晚开花时间
        }
        return ans;
    }
}
```