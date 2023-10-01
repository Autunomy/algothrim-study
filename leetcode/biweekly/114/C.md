与运算的结果一定是小于等于与运算两边的值，所以我们需要遍历数组，然后每当当前子数组的与运算结果为0，就给答案+1。有一个小技巧是使用-1作为与运算的开始，因为-1的二进制是补码形式，全为1，就不需要对val值单独判断了

```java
class Solution {
    public int maxSubarrays(int[] nums) {
        int res = 0;
        int val = -1;
        for(int i=0;i<nums.length;++i){
            val &= nums[i];
            if(val == 0) {
                res ++;
                val = -1;
            }
        }
        
        //防止数组只有一个元素
        return Math.max(res,1);
    }
}
```