# 暴力(超时)
暴力的思路就是遍历每个元素，以每个元素为最高点，求当前山峰的高度和并更新最大值，复杂度是O(n^2)的，对于10^5的数据范围是会超时的

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        for(int i=0;i<maxHeights.size();++i){
            long temp = maxHeights.get(i);
            int last = maxHeights.get(i);
            for(int j=i-1;j>=0;--j){
                if(maxHeights.get(j) <= last){
                    last = maxHeights.get(j);
                }
                temp += last;
            }
            last = maxHeights.get(i);
            for(int j=i + 1;j<n;++j){
                if(maxHeights.get(j) <= last){
                    last = maxHeights.get(j);
                }
                temp += last;
            }
            
            res = Math.max(res,temp);
        }
        
        return res;
    }
}
```

# 单调栈+前缀和
使用前缀和pre[i]来存储以i结尾的山峰且以i为最高点的左边山脉的高度和，使用end[i]表示以i结尾的山峰且以i为最高点的右边山脉的高度和。在求前缀和的过程中需要使用单调栈来进行优化，以pre为例，stack中元素是单调上升的，如果一个新的元素x进来后需要从栈顶弹出所有比x大的元素，然后再将x放入。那么我们每次都可以很快得到比当前元素x小的第一个元素，也就可以快速得到pre[i]应该添加的高度和

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] pre = new long[n];
        long[] end = new long[n];
        
        pre[0] = maxHeights.get(0);
        int[][] stack = new int[n][2];
        int top = -1;
        stack[++top][0] = maxHeights.get(0);
        stack[top][1] = 0;
        for(int i=1;i<n;++i){
            pre[i] = maxHeights.get(i);
            
            while(top != -1 && stack[top][0] > maxHeights.get(i)) top --;
            
            if(top == -1){
                pre[i] += i * (long)maxHeights.get(i);
            }else{
                int idx = stack[top][1];
                pre[i] += pre[idx] + (i-idx-1) * (long)maxHeights.get(i);
                
            }
            stack[++top][0] = maxHeights.get(i);
            stack[top][1] = i;
            
        }
        
        end[n-1] = maxHeights.get(n-1);
        stack = new int[n][2];
        top = -1;
        stack[++top][0] = maxHeights.get(n-1);
        stack[top][1] = n-1;
        
        for(int i=n-2;i>=0;--i){
            end[i] = maxHeights.get(i);
            
            while(top != -1 && stack[top][0] > maxHeights.get(i)) top --;
            
            if(top == -1){
                end[i] += (n-i-1) * (long)maxHeights.get(i);
            }else{
                int idx = stack[top][1];
                end[i] += end[idx] + (idx-i-1) * (long)maxHeights.get(i);
            }
            stack[++top][0] = maxHeights.get(i);
            stack[top][1] = i;
        }
        
        long res = 0;
        for(int i=0;i<n;++i){
            long temp = pre[i] + end[i] - maxHeights.get(i);
            res = Math.max(temp,res);
        }
        
        
        return res;
    }
}
```