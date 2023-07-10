//16. 最接近的三数之和
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i=0;i<n;++i){
            int j = i+1,k=n-1;
            while(j < k){
                if(j < k && abs(nums[i] + nums[j] + nums[k] - target) < abs(res - target)){
                    res = nums[i] + nums[j] + nums[k];
                }
                if(nums[i] + nums[j] + nums[k] > target) k--;
                else if(nums[i] + nums[j] + nums[k] < target) j++;
                else {
                    res = nums[i] + nums[j] + nums[k];
                    break;
                }

                if(j < k && abs(nums[i] + nums[j] + nums[k] - target) < abs(res - target)){
                    res = nums[i] + nums[j] + nums[k];
                }
            }
        }
        return res;
    }

    public int abs(int x){
        return x > 0 ? x : -x;
    }
}