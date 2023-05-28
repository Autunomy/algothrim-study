思路：以中心为界，从两边分别遍历查看需要反转的成本

```java
class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        int i = 1,j = n-2;
        long res = 0L;
        while(i <= j){
            if(s.charAt(i) != s.charAt(i - 1)) res += (long)i;
            if(s.charAt(j) != s.charAt(j + 1)) res += (long)(n-j-1);
            i++;
            j--;
        }
        i--;
        j++;
        if(s.charAt(i) != s.charAt(j)) res += (long)i + 1L;
        
        return res;
    }
}
```