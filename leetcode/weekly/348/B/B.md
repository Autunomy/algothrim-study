思路:先分别找到1和n的位置，标记为i和j,答案res = i + n - j - 1，还需要判断1是否是在n的后面，如果1在n的后面，res需要-1，因为1和n的交换被算了两次


```java
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int i = 0,j = n-1;
        while(nums[i] != 1) i++;

        while(nums[j] != n) j--;
        int res = i + n - j - 1;
        for(int k=0;k<n;++k){
            if(nums[k] == 1){
                break;
            }else if(nums[k] == n){
                res --;
                break;
            }
        }

        return res;
    }
}
```