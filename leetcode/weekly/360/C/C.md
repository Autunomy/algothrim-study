```java
/*
    题目的关键在于【全部为2的幂】这句话  利用贪心的思想，将target的每个二进制位凑出来即可
*/
class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int n = nums.size();
        int res = 0;
        //将nums中所有元素的二进制的1所在的位置的数量记录在cnt中
        int[] cnt = new int[32];
        for(int i=0;i<n;++i){
            //numberOfTrailingZeros方法可以获取到二进制中末尾0的个数 也就是获取到了最后一个1所在的下标
            int idx = Integer.numberOfTrailingZeros(nums.get(i));
            cnt[idx] ++;//进行累加
        }

        for(int i=0;i<31;++i){
            //只有target的当前位为1的时候才去找
            if(((target >> i) & 1) == 1){
                if(cnt[i] > 0){//如果nums中有这个位为1的数 就将数量-1即可
                    cnt[i] --;
                }else{//没有当前位为1的数字
                    int j = i;
                    //找到更大的数字
                    for(;j<31;++j){
                        if(cnt[j] != 0) break;
                    }
                    //如果没有就返回-1
                    if(j == 31) return -1;
                    res += j-i;//将操作次数也就是需要移动1的位数加入到答案中
                    cnt[j] --;//原位对应的数量-1
                    for(int k=j-1;k>=i;--k){//从i到j都+1  因为在/2的过程中每次都会产生两个 一个继续用来/2 另一个就不动了
                        cnt[k] ++;
                    }
                }
            }

            //关键 将小数字能够组成的大数字的数量加到大数字的数量中
            cnt[i + 1] += cnt[i] / 2; 
        }
        
        return res;

    }
}
```