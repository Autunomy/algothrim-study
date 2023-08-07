简单模拟即可

```java
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if(purchaseAmount % 10 == 0) return 100 - purchaseAmount;
        if(purchaseAmount % 10 >= 5) return 100 - (purchaseAmount / 10 + 1) * 10;
        return 100 - (purchaseAmount / 10) * 10;
    }
}
```