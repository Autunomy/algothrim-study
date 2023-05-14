/*
思路：优先将出现次数大的数先加入答案中。维护一个大根堆，每次都从堆中取出堆顶，如果堆顶和答案中的最后一个元素相同，那就取出第二大的元素
加入答案中
*/
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        int[] cnt = new int[10001];

        for(int i=0;i<n;++i) {
            cnt[barcodes[i]] ++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);

        for(int i=0;i<10001;++i) {
            if(cnt[i] != 0) q.offer(new int[]{i,cnt[i]});
        }

        int[] res = new int[n];
        for(int i=0;i<n;++i){
            int[] x = q.poll();
            if(i == 0){
                res[i] = x[0];
                if(x[1] - 1 > 0)
                    q.offer(new int[]{x[0],x[1]-1});
            }else{
                if(x[0] == res[i-1]){
                    int[] y = q.poll();
                    res[i] = y[0];
                    if(y[1] - 1 > 0)
                        q.offer(new int[]{y[0],y[1]-1});
                    q.offer(new int[]{x[0],x[1]});
                }else{
                    res[i] = x[0];
                    if(x[1] - 1 > 0)
                        q.offer(new int[]{x[0],x[1]-1});
                }
            }
        }
        return res;
    }
}