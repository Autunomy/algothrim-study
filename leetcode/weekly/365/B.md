A题和B题的区别就是数据范围的区别
我们可以使用一个数组arr来保存一段数组的最大值，用arr[i]表示从i到数组末尾的最大值，使用从后向前的方式遍历arr即可求出arr
然后我们使用双指针a是i，b是j，不断向后走，如果nums[b] < nums[a] 那就可以更新答案，更新的方式就是使用b+1到数组末尾的最大值作为k乘以(nums[a] - nums[b]) 之后让b继续向后走
如果nums[b] >= nums[a] 那么就需要将a移动到b，然后b继续向后走

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