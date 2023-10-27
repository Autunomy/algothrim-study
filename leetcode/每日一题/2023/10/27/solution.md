1465. 切割后面积最大的蛋糕

```java
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = getMaxSize(h, horizontalCuts);
        int maxW = getMaxSize(w, verticalCuts);
        return (int) ((long) maxH * maxW % 1_000_000_007);
    }

    private int getMaxSize(int size, int[] cuts) {
        Arrays.sort(cuts);
        int res = Math.max(cuts[0], size - cuts[cuts.length - 1]);
        for (int i = 1; i < cuts.length; i++) {
            res = Math.max(res, cuts[i] - cuts[i - 1]);
        }
        return res;
    }
}
```