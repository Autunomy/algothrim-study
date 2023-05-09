原题链接:[https://leetcode.cn/problems/Nsibyl/](https://leetcode.cn/problems/Nsibyl/)

思路:二分答案，因为满足单调性。
单调性证明：如果可以扩展3次也不重叠，那么一定可以扩展2次不重叠，如果扩展3次会重叠，那么扩展4次也会重叠
二分的下界是0，也就是不扩展，二分的上界所有相邻城墙之间的空隙之和s/中间的城墙数量n-2

```java
class Solution {
    int[][] nums;
    int n;
    public int rampartDefensiveLine(int[][] rampart) {
        n = rampart.length;
        nums = rampart;
        int left = -1,right = nums[n-1][0] - nums[0][1] + 1;
        for(int i=1;i<n-1;++i){
            right -= (nums[i][1] - nums[i][0]);
        }
        right /= (n-2);
        //二分答案
        while(left + 1 < right){
            int mid = (left + right) / 2; 
            if(check(mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }

    //判断扩展mx次是否出现重叠
    boolean check(int mx){
        //前一个城墙扩展之后最右边的坐标 最左边的城墙只需要无限的向左扩展，所以初始化就是第一个城墙的右端点
        int pre_right = nums[0][1];
        for(int i=1;i<n-1;++i){//遍历中间的城墙
            //对当前城墙的左边进行扩展后剩余的可扩展的数量
            int left = mx - (nums[i][0] - pre_right);
            //当前城墙的右端点
            int right = nums[i][1];
            if(left > 0){//如果左边城墙扩展完还有剩余
                right += left;//扩展到右边来
                if(right > nums[i+1][0]){//如果扩展后与下一个城墙重叠 就返回false
                    return false;
                }
            }
            //更新全局的左端点为当前城墙扩展后的右端点
            pre_right = right;
        }
        return true;
    }
}
```