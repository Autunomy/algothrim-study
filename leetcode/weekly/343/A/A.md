# A-[java]阅读理解

这个题目的翻译是真的有问题，看了很长时间都没看懂是只看前两轮还是i前的2轮。最后做出来才知道是i的前两轮

```java
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = 0;
        int sum2 = 0;
        int n = player1.length;
        for(int i=0;i<n;++i){
             sum1 += player1[i];
             sum2 += player2[i];
            
            if(i >= 2){
                if(player1[i-1] == 10 || player1[i-2] == 10) sum1 += player1[i];
                if(player2[i-1] == 10 || player2[i-2] == 10) sum2 += player2[i];
            }else if(i >= 1){
                if(player1[i-1] == 10) sum1 += player1[i];
                if(player2[i-1] == 10) sum2 += player2[i];
            }

        }
        
        if(sum1 > sum2) return 1;
        else if(sum1 < sum2) return 2;
        else return 0;
    }
}
```