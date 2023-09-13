注意需要特判起点和终点在一起的情况

```java
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int heng = Math.abs(fx-sx);
        int zong = Math.abs(fy-sy);

        int max = Math.max(heng,zong);

        if(max == 0){
            if(t == 1) return false;
            return true;
        }

        if(max <= t) return true;
        return false;
    }
}
```