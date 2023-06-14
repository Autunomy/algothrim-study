class Solution {
    public int numTimesAllBlue(int[] flips) {
        int right = -1;
        int n = flips.length;
        int[] arr = new int[n];
        int res = 0;
        for(int i=0;i<flips.length;++i){
            arr[flips[i] - 1] = 1;
            if(right == -1){
                if(arr[0] == 1) right = 0;
            }
            while(right >= 0 && right < n && arr[right] == 1) right++;
            
            if(right > i) {
                res++;
            }
        }
        return res;
    }
}