//15. 三数之和
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        Arrays.sort(nums);
        while(start < nums.length - 2){
            if(nums[start] > 0) break;
            if(start > 0 &&nums[start] == nums[start -1]) {
                start ++;
                continue;
            }
            int left = start + 1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[start] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[start],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left ++;
                    while(left < right && nums[right] == nums[right - 1])right --;
                    left ++;
                    right --;
                }else if(sum > 0){
                    right --;
                }else{
                    left ++;
                }
            }
            start ++;
        }
        return res;
    }
}