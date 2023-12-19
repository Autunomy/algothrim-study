1901. 寻找峰值 II

```java
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int left = -1, right = mat.length - 1;
        while (left + 1 < right) {
            int i = (left + right) >>> 1;
            int j = indexOfMax(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                right = i; // 峰顶行号 <= i
            } else {
                left = i; // 峰顶行号 > i
            }
        }
        return new int[]{right, indexOfMax(mat[right])};
    }

    private int indexOfMax(int[] a) {
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
```