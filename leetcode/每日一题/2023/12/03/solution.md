1423. 可获得的最大点数

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i=0;i<k;++i){
            sum += cardPoints[i];
        }

        int left = k-1;
        int n = cardPoints.length;
        List<Integer> list = new ArrayList<>();
        list.add(sum);
        while(left > -1){
            sum = sum - cardPoints[left] + cardPoints[n-(k-left)];
            System.out.println(sum);
            list.add(sum);
            left--;
        }
        int res = 0;
        for(int i:list){
            res = Math.max(i,res);
        }
        return res;
    }
}
```