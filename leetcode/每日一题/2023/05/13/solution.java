class Solution {
    public int findMaxK(int[] nums) {
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
            set.add(nums[i]);
        }
        int res = -1;
        for(int i = 0;i<set.size();++i){
            if(set.contains(-set.get(i))){
                res = Math.max(Math.abs(set.get(i)),res);
            }
        }
        return res;
    }
}