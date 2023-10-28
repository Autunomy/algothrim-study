2558. 从数量最多的堆取走礼物

```java
class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        Arrays.sort(gifts);
        for(int i=0;i<k;++i){
            gifts[n-1] = (int)Math.sqrt(gifts[n-1]);
            Arrays.sort(gifts);
        }
        long res = 0;
        for(int i=0;i<n;++i) res += gifts[i];
        return res;
    }
}
```