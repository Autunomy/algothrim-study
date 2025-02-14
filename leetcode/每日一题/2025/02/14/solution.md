1552.两球之间的磁力

经典的二分答案题

二分答案，排序，贪心

```java
import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int left = 1, right = position[n - 1];
        int res = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(position, mid, m, n)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public boolean check(int[] position, int dis, int m, int n) {

        int temp = position[0];
        int cnt = 1;
        // 贪心
        for(int i = 1; i < n; ++ i) {
            if(position[i] - temp >= dis) {
                temp = position[i];
                cnt ++;
            }
        }

        return cnt >= m;
    }
}
```