[灵神题解](https://leetcode.cn/problems/count-pairs-of-points-with-distance-k/)

```java
class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        Map<Long,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<coordinates.size();++i){
            int x = coordinates.get(i).get(0);
            int y = coordinates.get(i).get(1);
            for(int j=0;j<=k;++j){
                res += map.getOrDefault((x ^ j) * 2000000L + (y ^ (k - j)),0);
            }

            map.put(x * 2000000L + y,map.getOrDefault(x * 2000000L + y,0) + 1);
        }

        return res;
    }
}
```