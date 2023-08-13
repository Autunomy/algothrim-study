//88.合并两个有序数组
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[n+m];
        int i=0,j=0,cnt=0;
        while(i < m && j < n){
            if(nums1[i] >= nums2[j]){
                res[cnt++] = nums2[j++];
            }else{
                res[cnt++] = nums1[i++];
            }
        }
        while(i < m) res[cnt++] = nums1[i++];
        while(j < n) res[cnt++] = nums2[j++];
        for(int k=0;k<m+n;++k){
            nums1[k] = res[k];
        }
    }
}