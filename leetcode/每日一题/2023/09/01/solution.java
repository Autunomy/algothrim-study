//2240.买钢笔和铅笔的方案数
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        while(total >= 0){
            res += ((long)total / cost2) + 1L;
            total -= cost1;
        }

        return res;
    }       
}