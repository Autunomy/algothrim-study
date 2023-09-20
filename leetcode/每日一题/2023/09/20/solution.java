//LCP 06. 拿硬币
class Solution {
    public int minCount(int[] coins) {
        int res = 0;
        for(int i=0;i<coins.length;++i){
            res += coins[i] / 2 + (coins[i]%2==0?0:1);
        }
        return res;
    }
}