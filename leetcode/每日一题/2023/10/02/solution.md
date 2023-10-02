122. 买卖股票的最佳时机 II
遍历的过程中不断统计最小和最大值并累加到答案中
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;++i){
            if(prices[i] >= prices[i-1]) max = prices[i];
            else{
                res += (max-min);
                min = prices[i];
                max = prices[i];
            }
        }
        res += (max-min);
        return res;
    }
}
```