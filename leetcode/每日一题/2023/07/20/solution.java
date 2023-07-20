//918. 环形子数组的最大和
//本题类似于：53. 最大子数组和
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        int sum = nums[0];
        int maxRes = nums[0];
        for(int i=1;i<n;++i){
            if(dp1[i-1] > 0) dp1[i] = dp1[i-1] + nums[i];
            else dp1[i] = nums[i];
            maxRes = Math.max(dp1[i],maxRes);
            sum += nums[i];
        }

        int[] dp2 = new int[n];
        dp2[0] = nums[0];
        int minRes = 0;//开始设置为0，防止的是数组元素数量小于等于2，导致最后sum-minRes等于0
        //注意这里的范围时到n-1
        for(int i=1;i<n-1;++i){
            if(dp2[i-1] < 0) dp2[i] = dp2[i-1] + nums[i];
            else dp2[i] = nums[i];
            minRes = Math.min(dp2[i],minRes);
        }
        return Math.max(maxRes,sum - minRes);
    }
}