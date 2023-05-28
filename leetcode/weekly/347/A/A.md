思路：简单模拟

```java
class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length()-1;
        while(i >= 0 && num.charAt(i) == '0') i--;
        if(i == -1) return ""; 
        return num.substring(0,i+1);
    }
}
```