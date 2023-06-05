class Solution {
    public int[] applyOperations(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n-1;++i){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }

            if(nums[i] == 0) cnt++;
        }
        
        int[] res = new int[n];
        int idx = 0;
        for(int i=0;i<n;++i){
            if(nums[i] != 0){
                res[idx++] = nums[i];
            }
        }
        while(cnt -- > 0) res[idx ++] = 0;

        return res;
    }
}