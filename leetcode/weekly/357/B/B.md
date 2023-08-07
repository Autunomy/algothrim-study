只要满足中间连续两个数字存在大于等于m的一组，那么一定返回true，因为就可以从两边每次删除一个，直到删除完成

坑：数组长度为1或2的时候不走循环，需要特判

```java
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        
        int n = nums.size();
        
        if(n == 1 || n == 2) return true;
        
        for(int i=0;i<n-1;++i){
            if(nums.get(i) + nums.get(i + 1) >= m) return true;
        }

        return false;
    }
}
```