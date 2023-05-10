/*
题目：1015. 可被 K 整除的最小整数
原题链接：https://leetcode.cn/problems/smallest-integer-divisible-by-k/description/

思路:
可以从x = 1开始找，判断1,11,111,1111...是否能整除k，但是在一定次数之后，x就会爆int，那么就需要进行优化
我们每次不需要完全将x变为(x*10+1),而是将其中x%k不断的变为((x%k)*10 +1)
这么做的原因就是: x-(x%k)是k的倍数 设为ak 那么(x*10+1) x可以写成(ak + x%k)那么式子变形为(ak*10 + (x%k)*10 + 1)，这个式子
ak*10一定是k的倍数，可以直接省去，只需要判断后面两项是不是k的倍数即可
一次类推：每次都x更新为((x%k)*10 +1)即可

*/
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0) return -1;
        int q = 0;
        for(int i=1;i<=k;++i){
            if((q*10 + 1) % k == 0){
                return i;
            }
            q = (q%k)*10 + 1;
        }
        return -1;
    }
}