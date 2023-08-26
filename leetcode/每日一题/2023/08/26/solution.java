//228.汇总区间
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        int left = 0,right = 1;
        while(right < n){
            while(right < n && nums[right] - nums[right - 1] == 1) right ++;

            if(right - left == 1){
                list.add(nums[left] + "");
            }else{
                list.add(nums[left] + "->" + nums[right - 1]);
            }
            left = right;
            right ++;
        }

        if(left == n-1) {
            list.add(nums[left] + "");
        }else if(left < n - 1){
            list.add(nums[left] + "->" + nums[n-1]);
        }

        return list;
    }
}