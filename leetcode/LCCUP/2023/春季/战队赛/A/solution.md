原题链接:[https://leetcode.cn/problems/W2ZX4X/](https://leetcode.cn/problems/W2ZX4X/)

思路：求相邻元素之差不超过1的最长子数组

```java
class Solution {
    public int runeReserve(int[] runes) {
        Arrays.sort(runes);
        int n = runes.length;
        int res = 0;
        int cnt = 1;
        for(int i=1;i<n;++i){
            if(runes[i] - runes[i-1] <= 1) cnt++;
            else{
                res = Math.max(res,cnt);
                cnt = 1;
            }
        }
        res = Math.max(res,cnt);
        return res;
    }
}
```