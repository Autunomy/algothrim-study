//2208.将数组和减半的最少操作次数
//题解地址：http://www.autunomy.top/solution/content/314
class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        double target = 0;

        PriorityQueue <Double> queue = new PriorityQueue<Double>((o1,o2) -> o2.compareTo(o1));
        for(int i=0;i<nums.length;++i){
            sum += nums[i];
            queue.offer(nums[i] * 1.0);
        }

        target = sum / 2.0;

        int ops = 0;
        while(sum > target){
            double val = queue.poll();
            ops ++;
            sum -= val / 2.0;
            queue.offer(val / 2.0);
        }

        return ops;
        
    }
}