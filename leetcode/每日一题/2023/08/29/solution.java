//823.带因子的二叉树
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            idx.put(arr[i], i);
        }
        long ans = 0;
        long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            f[i] = 1;
            for (int j = 0; j < i; ++j) {
                int x = arr[j];
                if ((long) x * x > val) { // 防止乘法溢出
                    break;
                }
                if (x * x == val) {
                    f[i] += f[j] * f[j];
                    break;
                }
                if (val % x == 0 && idx.containsKey(val / x)) {
                    f[i] += f[j] * f[idx.get(val / x)] * 2;
                }
            }
            ans += f[i];
        }
        return (int) (ans % MOD);
    }
}