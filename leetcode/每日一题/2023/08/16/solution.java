//	2682.找出转圈游戏输家
class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] cnt = new int[n];
        int lun = 1;
        int idx = 0;
        while(cnt[idx] == 0){
            cnt[idx] = 1;
            idx = (idx + lun * k) % n;
            lun++;
        }
        int sum = 0;
        for(int i=0;i<n;++i) {
            if(cnt[i] == 0) sum ++;
        }
        int[] res = new int[sum];
        int x = 0;
        for(int i=0;i<n;++i) {
            if(cnt[i] == 0) res[x ++] = i + 1;
        }
        return res;
    }
}