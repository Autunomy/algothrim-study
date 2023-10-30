275. H 指数 II

```java
class Solution {
    public int hIndex(int[] citations) {
        // 在区间 (left, right) 内询问
        int n = citations.length;
        int left = 0;
        int right = n + 1;
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // left 的回答一定为「是」
            // right 的回答一定为「否」
            int mid = (left + right) >>> 1;
            // 引用次数最多的 mid 篇论文，引用次数均 >= mid
            if (citations[n - mid] >= mid) {
                left = mid; // 询问范围缩小到 (mid, right)
            } else {
                right = mid; // 询问范围缩小到 (left, mid)
            }
        }
        // 根据循环不变量，left 现在是最大的回答为「是」的数
        return left;
    }
}
```