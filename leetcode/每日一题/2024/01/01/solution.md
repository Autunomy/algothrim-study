1599. 经营摩天轮的最大利润

```java
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int number = 0;//转动次数
        int res = 0;//利润
        int person = 0;
        int i = 0;
        while(i<customers.length){
            person += customers[i];
            if(person >= 4) {
                person -= 4;
                res += (4*boardingCost - runningCost);
            }else if(person > 0){
                res += (person * boardingCost - runningCost);
                person = 0;
            }
            number ++;
            i++;
        }
        while(person >= 4){
            res += (4*boardingCost - runningCost);
            person -= 4;
            number ++;
        }
        if(person > 0 && person * boardingCost - runningCost > 0) {
            res += (person * boardingCost - runningCost); 
            number ++;
        }
        // res -= 3 * runningCost;
        if(res <= 0) return -1;
        return number;
    }
}
```