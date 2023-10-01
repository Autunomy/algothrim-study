首先求出nums的和，判断target中需要包含多少组的nums，并同时求出余数mod(出去很多个nums后剩下的值)，求出来之后我们构造一个2倍长的nums数组，相当于将nums又追加在nums后面形成一个2*n长度的数组，然后我们在构造出来的数组中求出和为mod的子数组即可

为什么可以直接在新数组中找子数组而不用管与前面很多个nums数组是否是连续的？
因为假如新数组的前几个元素需要删除那么我们就可以调整前面的很多个nums数组将其向后移动，那么就相当于将整个无限长数组的最前面几个元素删除，与删除新数组的前几个元素的效果相同

```java
class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        
        int n = nums.length;
        int left = 0,right = 0;
        int arrSum = 0;
        int sum = 0;
        
        int[] arr = new int[2 * n];
        for(int i=0;i<n;++i){
            arr[i] = nums[i];
            arr[i + n] = nums[i];
            arrSum += nums[i];
        }
        
        if(target%arrSum == 0) return n * (target/arrSum);

        int temp = n * (target/arrSum);
        target = target % arrSum;
        int res = Integer.MAX_VALUE;
        
        while(right < 2 * n){
            if(sum < target){
                sum += arr[right];
                right ++;
            }else if(sum == target){
                res = Math.min(res,right - left);
                sum -= arr[left];
                left ++;
            }else{
                sum -= arr[left];
                left ++;
            }
        }
        
        
        return res == Integer.MAX_VALUE?-1:res+temp;
    }
}
```