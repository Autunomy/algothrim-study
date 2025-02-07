[59]螺旋矩阵 II	

按照顺时针的顺序，依次填充每条边

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int cnt = 1;
        for(int i = 0; i < n/2 + (n&1); ++ i) {
            // 第一条边每个位置都填充
            for(int j = i; j < n-i; ++ j) { // 上
                res[i][j] = cnt;
                cnt ++;
            }

            // 第一条边已经把右上角的元素，填充了，第二条边就不填充
            for(int j = i+1; j < n-i; ++ j) { // 右
                res[j][n-i-1] = cnt;
                cnt ++;
            }

            // 第二条边已经把右下角的元素，填充了，第三条边就不填充
            for(int j = n-i-2; j >= i; -- j) { // 下
                res[n-i-1][j] = cnt;
                cnt ++;
            }

            // 第三条边已经把左下角的元素，填充了，第一条边已经把，第四条边就不填充
            for(int j = n-i-2; j >= i+1; -- j) { // 左
                res[j][i] = cnt;
                cnt++;
            }
        }

        return res;
    }
}
```
