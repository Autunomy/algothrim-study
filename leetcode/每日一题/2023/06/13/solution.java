class Solution {
    public int unequalTriplets(int[] nums) {
        int ans=0,pre=0;
        int n=nums.length;
        int[] cnt=new int[1001];
        boolean[] vis=new boolean[1001];
        for(int i=0;i<n;i++){
            cnt[nums[i]]++;
        }
        for(int i=0;i<n;i++){
            if(vis[nums[i]]) continue;
            vis[nums[i]]=true;
            ans+=pre*cnt[nums[i]]*(n-pre-cnt[nums[i]]);
            pre+=cnt[nums[i]];
        }
        return ans;
    }
}