//849.到最近的人的最大距离
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int last = -1;
        int res = 0;
        for(int i=0;i<n;++i){
            if(seats[i] == 1){
                if(last == -1) res = i;
                else{
                    res = Math.max(res,(i - last) / 2);
                }

                last = i;
            }
        }
        
        res = Math.max(res,n-1-last);

        return res;
    }
}