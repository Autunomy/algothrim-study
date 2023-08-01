//2681.英雄的力量
class Solution {
    public int sumOfPower(int[] nums) {
        long mod = 1000000007;
        Arrays.sort(nums);
        long s = 0,res = 0;
        for(int i=0;i<nums.length;++i){
            res = (res + (long)nums[i] * nums[i]  % mod * (nums[i] + s) % mod)%mod;
            s = (s * 2 + nums[i])%mod;
        }

        return (int)res;
    }
}