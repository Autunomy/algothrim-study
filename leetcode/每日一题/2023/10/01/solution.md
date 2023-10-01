121. 买卖股票的最佳时机
保存最小值并不断更新答案即可
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;

        for(int i=1;i<prices.length;++i){
            if(prices[i] < min){
                min = prices[i];
            }else{
                res = Math.max(res,prices[i] - min);
            }
        }

        return res;
    }
}
```