2645. 构造有效字符串的最少插入数

```java
class Solution {
    public int addMinimum(String word) {
        int res = 0;
        int n = word.length();
        int ops = 0;
        for(int i=0;i<n;){
            if(word.charAt(i) == 'a' + ops) {
                i++;
            }
            else res++;
            ops = (ops+1)%3;
        }
        if(word.charAt(n-1) == 'a') res += 2;
        if(word.charAt(n-1) == 'b') res += 1;
        
        return res;
    }
}
```