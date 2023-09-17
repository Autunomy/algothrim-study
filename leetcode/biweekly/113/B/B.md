left从头开始，right从中间开始向后匹配，如果left < right 就将两个都删除，如果left >= right 就给right ++即可
注意题目条件是非递减序列

```java
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int left = 0,right = nums.size()/2 + (nums.size()%2==0?0:1);
        int res = 0;
        while(right < nums.size()){
            if(nums.get(left) < nums.get(right)){
                left ++;
                right ++;
                res += 2;
                
            }else{
                right ++;
            }
        }
        return nums.size() - res;
    }
}
```