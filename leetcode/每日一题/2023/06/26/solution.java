//2485. 找出中枢整数
class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i=1;i<=n;++i){
            sum += i;
        }
        int l = sum,r = n;
        int cnt = n-1;
        while(l > r){
            r+=cnt;
            l-=cnt+1;
            cnt--;
        }
        if(r == l) return cnt+1;
        else return -1;
    }
}