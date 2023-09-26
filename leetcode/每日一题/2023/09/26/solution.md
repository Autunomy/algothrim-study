2582. 递枕头
暴力模拟
模拟整个过程，使用一个flag标记当前应该向前还是向后传递枕头，用idx表示枕头当前所在的位置
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
假设从1传递到n或从n传递到1都算作一次完整的传递，那么通过time/总传递次数  就可以得到完成的传递次数，这个就代表了进行了多少轮，如果是奇数，则代表当前应该从后向前传递，反之代表从前向后传递。yu代表余数，也就是除了完成的传递还有一部分传递不能形成完成的传递，那么就需要计算出当前所处的位置
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