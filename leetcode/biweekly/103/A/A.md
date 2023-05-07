# A-[java]简单模拟

```java
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;++i){
            if(nums[i] > max) max = nums[i];
        }
        int sum = 0;
        for(int i=0;i<k;++i){
            sum += max;
            max++;
        }
        return sum;
    }
}
```