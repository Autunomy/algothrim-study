2923. 找到冠军 I

```java
class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] line = grid[i];
            int sum = 0;
            for (int num : line) {
                sum += num;
            }
            if (sum == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
```