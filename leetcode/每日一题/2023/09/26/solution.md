2582. 递枕头
暴力
```java
class Solution {
    public int passThePillow(int n, int time) {
        int idx = 1;
        boolean flag = true;
        while(time -- > 0){
            if(flag){
                idx++;
            }else{
                idx --;
            }

            if(idx == n || idx == 1){
                flag = !flag;
            }
        }
        return idx;
    }
}
```

O(1)做法
```java
class Solution {
    public int passThePillow(int n, int time) {
        int yu = time % (n - 1);
        int chu = time / (n - 1);
        if(chu % 2 == 0) return 1 + yu;
        else return n - yu;
    }
}
```