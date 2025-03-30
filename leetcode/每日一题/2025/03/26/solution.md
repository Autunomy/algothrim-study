2829. k-avoiding 数组的最小总和

```java
class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> hasValue = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        int ans = 0;
        int idx = 1;
        while(res.size() < n) {
            if(hasValue.contains(idx)) {
                idx ++;
                continue;
            }

            hasValue.add(idx);
            if(idx < k) {
                hasValue.add(k - idx);
            }

            res.add(idx);
            ans += idx;
            idx ++;

        }
        return ans;
    }
}
```