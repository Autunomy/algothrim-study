2216. 美化数组的最少删除数

```java
class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((i - cnt) % 2 == 0 && i + 1 < n && nums[i] == nums[i + 1]) cnt++;
        }
        return (n - cnt) % 2 != 0 ? cnt + 1 : cnt;
    }
}
```