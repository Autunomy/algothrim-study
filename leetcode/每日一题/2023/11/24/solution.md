2824. 统计和小于目标的下标对数目

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // Collections.sort(nums);
        int n = nums.size();
        int res = 0;
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                if(nums.get(i) + nums.get(j) < target) res ++;
            }
        }

        return res;
    }
}
```