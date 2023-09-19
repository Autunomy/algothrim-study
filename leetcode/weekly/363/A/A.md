暴力遍历即可

```java
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int res = 0;
        for(int i=0;i<nums.size();++i){
            int val = i;
            int cnt = 0;
            while(val > 0){
                if((val & 1) == 1){
                    cnt ++;
                }

                val >>= 1;
            }
            if(cnt == k){
                res += nums.get(i);
            }
        }
        return  res;
    }
}
```