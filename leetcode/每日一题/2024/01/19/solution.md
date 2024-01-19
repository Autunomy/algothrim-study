2809. 使数组和小于等于 x 的最少时间

```java
class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        // 对下标数组排序，避免破坏 nums1 和 nums2 的对应关系
        var ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            s1 += nums1.get(i);
            s2 += nums2.get(i);
        }
        Arrays.sort(ids, (i, j) -> nums2.get(i) - nums2.get(j));

        var f = new int[n + 1];
        for (int i : ids)
            for (int j = n; j > 0; j--)
                f[j] = Math.max(f[j], f[j - 1] + nums1.get(i) + nums2.get(i) * j);

        for (int t = 0; t <= n; t++)
            if (s1 + s2 * t - f[t] <= x)
                return t;
        return -1;
    }
}
```