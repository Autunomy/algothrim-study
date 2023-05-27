思路：排序，将所有的正数乘起来，如果负数的个数为偶数则乘以所有负数，如果为奇数，则不乘最大的负数
注意：有可能包含0，如果是[-1,0]则答案为0,如果为[1,0]答案为1,[0]答案为0,特殊情况需要处理一下

```java
class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        boolean flag = false;
        
        Arrays.sort(nums);
        long res = 1;
        
        for(int i=n-1;i>=0;--i){
            if(nums[i] > 0){
                res *= (long)nums[i];
                flag = true;
            }
        }
        
        for(int i=0;i<n;i+=2){
            if(i+1 < n && nums[i+1] < 0){
                res *= (long)nums[i] * (long)nums[i+1];
                flag = true;
            }
        }
        
        if(!flag){
            return 0;
        }
        return res;
    }
}
```