2908. 元素和最小的山形三元组 I

```java
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length, res = 1000;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        res = Math.min(res, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return res < 1000 ? res : -1;
    }
}
```