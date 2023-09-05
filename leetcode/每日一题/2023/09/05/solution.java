//2605. 从两个数字数组里生成最小数字
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = Integer.MAX_VALUE;

        for(int i=0;i<nums1.length;++i){
            for(int j=0;j<nums2.length;++j){
                if(nums1[i] == nums2[j]){
                    res = Math.min(res,nums1[i]);
                }
            }
        }
        if(res != Integer.MAX_VALUE) return res;

        if(nums1[0] < nums2[0]) return nums1[0]*10 + nums2[0];
        else return nums1[0]+nums2[0]*10;
    }
}