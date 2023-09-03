//1921. 消灭怪物的最大数量
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = (dist[i] / speed[i] + (dist[i] % speed[i] == 0 ? 0 : 1)) - 1;
        }
        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0;i<n;++i){
            if(arr[i] >= cnt) {
                cnt++;
            }else{
                return cnt;
            }
        }
        return cnt;
    }
}