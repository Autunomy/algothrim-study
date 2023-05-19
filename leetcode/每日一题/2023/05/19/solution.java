public class Solution {

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            count[c - 'A']++;
        }
        // tiles 里所有的信息都存在 count 里，对 count 执行深度优先遍历即可
        return dfs(count);
    }
    private int dfs(int[] count) {
        // 递归终止条件是：当前没有可以用的字符（没有显示递归终止条件）
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            res++;
            count[i]--;

            res += dfs(count);
            // 只需要重置字符频数数组
            count[i]++;
        }
        return res;
    }
}