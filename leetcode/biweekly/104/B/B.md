思路:矩阵的每一行都进行排序，然后从右到左遍历每一行，从上到下遍历每一列，取每一列的最大值加入到res中返回即可

```java
class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int res = 0;
        for(int i=0;i<n;++i) Arrays.sort(nums[i]);
        
        for(int i=m-1;i>=0;--i){
            int temp = nums[0][i];
            for(int j=1;j<n;++j){
                temp = Math.max(temp,nums[j][i]);
            }
            res += temp;
        }
        return res;
    }
}
```