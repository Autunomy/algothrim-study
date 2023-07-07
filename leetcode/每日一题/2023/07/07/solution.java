//2532. 过桥的时间
class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        Arrays.sort(time, (a, b) -> a[0] + a[2] - b[0] - b[2]); // 稳定排序
        
        var workL = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        var workR = new PriorityQueue<int[]>(workL.comparator());
        var waitL = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]); // 下标越大效率越低
        var waitR = new PriorityQueue<int[]>(waitL.comparator());
        for (int i = k - 1; i >= 0; --i) 
            waitL.add(new int[]{i, 0});
        
        int cur = 0;
        while (n > 0) {
            while (!workL.isEmpty() && workL.peek()[1] <= cur) waitL.add(workL.poll()); // 左边完成放箱
            while (!workR.isEmpty() && workR.peek()[1] <= cur) waitR.add(workR.poll()); // 右边完成搬箱
            if (!waitR.isEmpty()) { // 右边过桥，注意加到 waitR 中的都是 <= cur 的（下同）
                var p = waitR.poll();
                cur += time[p[0]][2];
                p[1] = cur + time[p[0]][3];
                workL.add(p); // 放箱
            } else if (!waitL.isEmpty()) { // 左边过桥
                var p = waitL.poll();
                cur += time[p[0]][0];
                p[1] = cur + time[p[0]][1];
                workR.add(p); // 搬箱
                --n;
            } else if (workL.isEmpty()) cur = workR.peek()[1]; // cur 过小，找个最小的放箱/搬箱完成时间来更新 cur
            else if (workR.isEmpty()) cur = workL.peek()[1];
            else cur = Math.min(workL.peek()[1], workR.peek()[1]);
        }
        while (!workR.isEmpty()) {
            var p = workR.poll(); // 右边完成搬箱
            // 如果没有排队，直接过桥；否则由于无论谁先过桥，最终完成时间都一样，所以也可以直接计算
            cur = Math.max(p[1], cur) + time[p[0]][2];
        }
        return cur; // 最后一个过桥的时间
    }
}