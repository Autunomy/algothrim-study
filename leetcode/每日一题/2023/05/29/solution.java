class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]%3 == 0 && nums[i]%2 == 0) {
                sum += nums[i];
                cnt++;
            }
        }
        if(cnt == 0) return 0;
        return sum/cnt;
    }
}