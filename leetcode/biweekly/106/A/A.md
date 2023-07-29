思路：1到9各出现一次且不能出现0，则代表长度必须为9，这个就是终止条件，然后进行简单模拟即可

```java
class Solution {
    public boolean isFascinating(int n) {
        String temp = "";
        //获取长度为9的字符串
        while(temp.length() < 9){
            temp = "" + n + n*2 + n * 3;
            if(temp.length() < 9)
                n = Integer.valueOf(temp);
        }

        //长度不能等于9 直接返回false
        if(temp.length() != 9) return false;
        int[] cnt = new int[10];
        for(int i=0;i<9;++i){
            cnt[temp.charAt(i)-'0'] ++;
        }
        for(int i=1;i<10;++i){
            if(cnt[i] == 0){
                return false;
            }
        }
        return true;
    }
}
```