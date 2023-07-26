//2569.更新数组后处理求和查询
class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = 0, i = 0;
        cnt1 = new int[n * 4];
        flip = new boolean[n * 4];
        build(nums1, 1, 1, n);

        var sum = 0L;
        for (var x : nums2)
            sum += x;

        for (var q : queries)
            if (q[0] == 3) ++m;
        var ans = new long[m];
        for (var q : queries) {
            if (q[0] == 1) update(1, 1, n, q[1] + 1, q[2] + 1);
            else if (q[0] == 2) sum += (long) q[1] * cnt1[1];
            else ans[i++] = sum;
        }
        return ans;
    }

    private int[] cnt1;
    private boolean[] flip;

    // 维护区间 1 的个数
    private void maintain(int o) {
        cnt1[o] = cnt1[o * 2] + cnt1[o * 2 + 1];
    }

    // 执行区间反转
    private void do_(int o, int l, int r) {
        cnt1[o] = r - l + 1 - cnt1[o];
        flip[o] = !flip[o];
    }

    // 初始化线段树   o,l,r=1,1,n
    private void build(int[] a, int o, int l, int r) {
        if (l == r) {
            cnt1[o] = a[l - 1];
            return;
        }
        int m = (l + r) / 2;
        build(a, o * 2, l, m);
        build(a, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    // 反转区间 [L,R]   o,l,r=1,1,n
    private void update(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            do_(o, l, r);
            return;
        }
        int m = (l + r) / 2;
        if (flip[o]) {
            do_(o * 2, l, m);
            do_(o * 2 + 1, m + 1, r);
            flip[o] = false;
        }
        if (m >= L) update(o * 2, l, m, L, R);
        if (m < R) update(o * 2 + 1, m + 1, r, L, R);
        maintain(o);
    }
}