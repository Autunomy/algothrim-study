2765. 最长交替子数组

```java
class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        for (int firstIndex = 0; firstIndex < n; firstIndex++) {
            for (int i = firstIndex + 1; i < n; i++) {
                int length = i - firstIndex + 1;
                if (nums[i] - nums[firstIndex] == (length - 1) % 2) {
                    res = Math.max(res, length);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
```