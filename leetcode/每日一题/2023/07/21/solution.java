//1499. 满足不等式的最大值
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        var q = new ArrayDeque<int[]>();
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!q.isEmpty() && q.peekFirst()[0] < x - k) // 队首超出范围
                q.pollFirst(); // 弹它！
            if (!q.isEmpty())
                ans = Math.max(ans, x + y + q.peekFirst()[1]); // 加上最大的 yi-xi
            while (!q.isEmpty() && q.peekLast()[1] <= y - x) // 队尾不如新来的强
                q.pollLast(); // 弹它！
            q.addLast(new int[]{x, y - x});
        }
        return ans;
    }

}