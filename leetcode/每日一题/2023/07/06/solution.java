//2178. 拆分成最多数目的正偶数之和
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 > 0) return List.of();
        var ans = new ArrayList<Long>();
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        int back = ans.size() - 1;
        ans.set(back, ans.get(back) + finalSum);
        return ans;
    }
}
