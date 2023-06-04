class Solution {
    public int distinctAverages(int[] nums) {
        Set<Double> s = new HashSet<>();
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i < j){
            s.add((nums[i]+nums[j])/2.0);
            i++;
            j--;
        }
        return s.size();
    }
}