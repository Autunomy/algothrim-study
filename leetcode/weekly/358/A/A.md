```java
class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = -1;
        for(int i=n-1;i>=0;--i){
            for(int j=i-1;j>=0;j--){
                int maxa = 0,maxb = 0;
                int a = nums[i];
                int b = nums[j];
                while(a > 0){
                    maxa = Math.max(maxa,a%10);
                    a/=10;
                }
                while(b > 0){
                    maxb = Math.max(maxb,b%10);
                    b/=10;
                }
                if(maxa == maxb) {
                    res = Math.max(res,nums[i] + nums[j]);
                }
            }
        }
        return res;
    }
}
```