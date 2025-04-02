2873. 有序三元组中的最大值 I

```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=n-1;i>=2;--i){
            if(i == n-1){
                arr[i] = nums[i];
            }else{
                arr[i] = Math.max(arr[i+1],nums[i]);
            }
        }
        int a = 0,b = 1;
        long res = 0;
        while(b <= n-2){
            if(nums[b] <= nums[a]){
                res = Math.max(res,(nums[a] - nums[b]) * (long)arr[b + 1]);
            }else{
                a = b;
            }
            b ++;
        }

        return res;
    }
}
```