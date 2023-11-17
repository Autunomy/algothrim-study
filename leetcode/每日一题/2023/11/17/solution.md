2736. 最大和查询

```java
class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums1[i];
            a[i][1] = nums2[i];
        }
        Arrays.sort(a, (x, y) -> y[0] - x[0]);

        Integer[] qid = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid, (i, j) -> queries[j][0] - queries[i][0]);

        int[] ans = new int[queries.length];
        List<int[]> st = new ArrayList<>();
        int j = 0;
        for (int i : qid) {
            int x = queries[i][0], y = queries[i][1];
            for (; j < n && a[j][0] >= x; j++) { // 下面只需关心 a[j][1]
                while (!st.isEmpty() && st.get(st.size() - 1)[1] <= a[j][0] + a[j][1]) { // a[j][1] >= st.get(st.size()-1)[0]
                    st.remove(st.size() - 1);
                }
                if (st.isEmpty() || st.get(st.size() - 1)[0] < a[j][1]) {
                    st.add(new int[]{a[j][1], a[j][0] + a[j][1]});
                }
            }
            int p = lowerBound(st, y);
            ans[i] = p < st.size() ? st.get(p)[1] : -1;
        }
        return ans;
    }

    // 开区间写法，原理请看 b23.tv/AhwfbS2
    private int lowerBound(List<int[]> st, int target) {
        int left = -1, right = st.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1;
            if (st.get(mid)[0] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
```