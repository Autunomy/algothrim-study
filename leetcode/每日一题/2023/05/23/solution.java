class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;++i){
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }

        Arrays.sort(arr,(o1,o2) -> o2[0] - o1[0]);

        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int res = 0;
        for(int i=0;i<n;++i){
            if(cnt >= numWanted) break;
            if(map.getOrDefault(arr[i][1],0) < useLimit){
                map.put(arr[i][1],map.getOrDefault(arr[i][1],0) + 1);
                res += arr[i][0];
                cnt++;
            }
        }
        return res;
    }
}