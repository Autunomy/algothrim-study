//2594. 修车的最少时间
/*
    思路：r * n^2 是一个具有单调性的函数 => 可以使用二分来查找
    需要二分的集合是什么呢?
    设t = r * n^2 那么 n = sqrt(t / r) => 说明我们可以二分一下时间，判断每个时间内是否能够修对应数量的车
    二分的上下界是什么?
    下界肯定就是0 上界是 Min(ranks) * cars * cars
    注意:要使用long类型 不然会爆int
*/
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minT = ranks[0];
        for(int i:ranks) minT = Math.min(minT,i);
        long left = 0,right = minT * cars * cars;
        while(left < right){
            long mid = left + (right - left) / 2;
            if(check(mid,ranks,cars)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean check(long t,int[] ranks,int cars){
        int cnt = 0;
        for(int i=0;i<ranks.length;++i){   
            cnt += Math.sqrt(t / ranks[i]);
        }
        return cnt >= cars;
    }
}