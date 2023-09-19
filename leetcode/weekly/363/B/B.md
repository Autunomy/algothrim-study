排序，然后先判断选0个和选全部是否可行，然后再从第一个元素开始，一次判断每个学生是否可选

```java
class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);

        int n = nums.size();
        int res = 0;
        if(nums.get(0) > 0) res ++;
        if(nums.get(n - 1) < n) res ++;
        for(int i=0;i<n - 1;++i){
            if(nums.get(i) < i + 1 && nums.get(i + 1) > i + 1) {
                res ++;
            }
        }

        return res;
    }
}
```