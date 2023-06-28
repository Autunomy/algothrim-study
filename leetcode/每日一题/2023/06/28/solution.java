//1681. 最小不兼容性
class Solution {
  public int minimumIncompatibility(int[] nums, int k) {
        // 分组保证每组不包含重复数字
        int groupSize = nums.length / k;
        Arrays.sort(nums);
        int length = nums.length;
        HashMap<Integer, Integer> countrer = new HashMap<>();
        build(0, 0, nums, countrer, 0, length + 1, groupSize, 0);
        int[] dp = new int[(1 << nums.length)];
        Set<Integer> integerSet = countrer.keySet();
        int[] ints = new int[integerSet.size()];
        int i = 0;
        for (Integer integer : integerSet) ints[i++] = integer;
        Arrays.fill(dp, -2);
        return dfs1(0, (1 << nums.length) - 1, ints, 0, dp,countrer);
    }

    void build(int startindex, int pre, int[] nums, HashMap<Integer, Integer> counter, int max, int min, int level, int stau) {
        if (level == 0) {
            counter.put(stau, max - min);
            return;
        }
        for (int i = startindex; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            build(i + 1, nums[i], nums, counter, Math.max(max, nums[i]), Math.min(min, nums[i]), level - 1, (stau) | (1 << i));
        }
    }

    int dfs1(int used, int all, int[] arr, int index, int[] dp, HashMap<Integer, Integer> counter) {
        if (used == all) return 0;
        if (dp[used] != -2) return dp[used];
        int a = Integer.MAX_VALUE;
        for (int i = index; i < arr.length; i++) {
            if ((arr[i] & used) == 0) {
                int dfs = dfs1(arr[i] | used, all, arr, i + 1, dp, counter);
                if (dfs != -1) a = Math.min(a, counter.get(arr[i]) + dfs);
            }
        }
        dp[used] = (a == Integer.MAX_VALUE ? -1 : a);
        return dp[used];
    }
}