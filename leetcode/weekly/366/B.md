贪心  [灵神题解](https://leetcode.cn/problems/minimum-processing-time/solutions/2472127/tan-xin-pythonjavacgo-by-endlesscheng-8fzf/)

```java
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        tasks.sort(Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            ans = Math.max(ans, processorTime.get(i) + tasks.get(i * 4));
        }
        return ans;
    }
}
```