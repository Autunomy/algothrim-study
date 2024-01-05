1944. 队列中可以看到的人数

```java
// 更快的写法见数组版本
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < heights[i]) {
                st.pop();
                ans[i]++;
            }
            if (!st.isEmpty()) { // 还可以再看到一个人
                ans[i]++;
            }
            st.push(heights[i]);
        }
        return ans;
    }
}
```