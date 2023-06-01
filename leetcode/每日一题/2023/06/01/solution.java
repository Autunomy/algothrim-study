/*
    二分答案func(mid)表示糖果的最小绝对值差为mid的时候，至多能选多少个糖果
*/
class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        
        int left = 0,right = price[n-1] - price[0] + 1;
        //上界的优化写法就是 (price[n-1] - price[0])/(k-1) + 1
        //上界不会超过平均值，平均值指选了price最小最大以及中间的一些糖果，相邻糖果差值的平均值。
        //开区间二分写法
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(func(price,mid) >= k) left = mid;
            else right = mid;
        }

        return left;
    }

    //mid是相邻两个元素的差值的最小值
    int func(int[] price,int mid){
        //初始值是1，因为如果有满足条件的一对糖果那么cnt就需要变为2，如果cnt从0开始那就需要进行特殊处理
        //当第一组糖果出现的时候cnt+=2，剩下的+1，比较麻烦
        int cnt = 1;
        int pre = price[0];

        for(int i=1;i<price.length;++i){
            //当前项与上一个被选中的项的差值必须大于等于mid
            if(price[i] - pre >= mid){
                cnt++;
                pre = price[i];
            }
        }
        return cnt;
    }
}