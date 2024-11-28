3250. 单调数组对的数目 I
推荐题解：https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-i/solutions/3003908/javapython3cji-yi-hua-sou-suo-dong-tai-g-3d14
本次我使用记忆化搜索
格外注意在计算过程中使用long并在计算的时候，计算一次就取模一次，方式溢出long的范围
```java
class Solution {
    int mod = 1000000007;
    long[][] bak;
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        bak = new long[2010][100];
        for(int i = 0; i < n; ++ i) {
            Arrays.fill(bak[i], -1);
        }

        return (int)(dfs(nums, 0, 0, n) % mod);
    }

    public long dfs(int[] nums, int idx, int last, int n) {
        if(idx == n) {
            return 1;
        }

        if(bak[idx][last] != -1) {
            return bak[idx][last];
        }

        long sum = 0L;
        int min;
        if(idx == 0) min = 0;
        else min = Math.max(last, nums[idx] - nums[idx - 1] + last);
        int max = nums[idx];
        for(int i = min; i <= max; ++ i) {
            sum += dfs(nums, idx + 1, i, n) % mod;
        }
        bak[idx][last] = sum;

        return sum;
    }
}
```