2731. 移动机器人

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