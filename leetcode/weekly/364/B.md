B题和C题相同，详情看C题题解

# 暴力
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