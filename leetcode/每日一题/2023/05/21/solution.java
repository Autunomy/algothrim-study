/*
    用一个大根堆存储一个数组，数组包含两个值a[0]表示需要蓄水几次，a[1]代表下标
    如果vat[i]=0就不加入堆中，如果bucket[i]=0则将蓄水次数设置为最大值10000
    不断的对根进行操作，每次操作都将bucket[i]++，然后将新的蓄水次数放入堆中，
    注意：每操作一次根，cnt++,表示升级一次水桶
    用一个res维护最小操作次数，如果堆顶元素<=1就退出循环
*/
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int n = bucket.length;
        for(int i=0;i<n;++i){
            if(vat[i] == 0) {
            }else if(bucket[i] == 0){
                q.offer(new int[]{10000,i});
            }else if(vat[i] <= bucket[i]) {
                q.offer(new int[]{1,i});
            }
            else{
                q.offer(new int[]{vat[i] / bucket[i] + (vat[i] % bucket[i] == 0?0:1),i});
            }
        }
        if(q.size() == 0) return 0;
        int res = q.peek()[0];
        int cnt = 0;
        while(q.peek()[0] > 1){
            cnt++;
            int[] arr = q.poll();
            int i = arr[1];
            bucket[i] ++;
            if(vat[i] <= bucket[i]) q.offer(new int[]{1,i});
            else{
                q.offer(new int[]{vat[i] / bucket[i] + (vat[i] % bucket[i] == 0?0:1),i});
            }
            res = Math.min(res,cnt + q.peek()[0]);
        }
        return res;
    }
}