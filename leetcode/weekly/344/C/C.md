# C

使用一个变量cnt记录当前整个数组中相等的对数，每次修改一个格子的颜色只会影响到其相邻的两个格子，只需要判断相邻两个格子与当前格子即可

```java
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
	int[] nums = new int[n];
        int cnt = 0;
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;++i){
            int idx = queries[i][0];
            int c = queries[i][1];
            
            //如果旧颜色不为0
            if(nums[idx] != 0){
                //如果旧颜色与后面的颜色相同 那么就先让对数-1
                if(idx+1 < n && nums[idx] == nums[idx+1]) cnt--;
                //如果旧颜色与前面的颜色相同 那么就先让对数-1
                if(idx-1 >= 0 && nums[idx] == nums[idx-1]) cnt--;
            }
            //修改颜色
            nums[idx] = c;
            //如果新颜色与后面的颜色相同 那么就让对数+1
            if(idx+1 < n && nums[idx] == nums[idx+1]) cnt++;
            //如果新颜色与前 面的颜色相同 那么就让对数+1
            if(idx-1 >= 0 && nums[idx] == nums[idx-1]) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}
```