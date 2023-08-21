类似于两数之和
```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
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