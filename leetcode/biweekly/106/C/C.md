思路：
1. 机器人之间没有区别，碰撞可以直接看做是两个机器人互相穿过对方
2. 统计所有机器人之间的距离之和的时候可以先排序，然后观察规律
   `(a[i]−a[0])+(a[i]−a[1])+⋯+(a[i]−a[i−1])= i⋅a[i]−(a[0]+a[1]+⋯+a[i−1])`
​所以可以利用一次遍历就将所有距离之和计算出来

```java
class Solution {
    long mod = 1000000007;
    public int sumDistance(int[] nums, String s, int d) {
        long res = 0;
        int n = nums.length;
        long[] temp = new long[n];
        for(int i=0;i<n;++i){
            if(s.charAt(i) == 'L') temp[i] = (long)nums[i] - d;
            else temp[i] = (long)nums[i] + d;
        }
        for(int i=0;i<n;++i){
            System.out.println(temp[i]);
        }
        Arrays.sort(temp);
        long sum = 0;
        for(int i=0;i<n;++i){
            res = (res + i*temp[i] - sum) % mod;
            sum += temp[i];
        }
        return (int)res;
    }
}
```