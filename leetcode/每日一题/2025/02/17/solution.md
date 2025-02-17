[1287]有序数组中出现次数超过25%的元素.java

统计数量，题目中保证恰好有一个整数，所以输出出现次数最多的元素即可

```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[][] nums = new int[100010][2];
        for(int i = 0; i < n; ++ i) {
            nums[arr[i]][0] ++;
            nums[arr[i]][1] = arr[i];
        }

        Arrays.sort(nums, (a1, a2) -> {
            return a2[0] - a1[0];
        });


        return nums[0][1];
    }
}
```