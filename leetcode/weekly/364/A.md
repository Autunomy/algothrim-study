只要保证最后一位是1(保证是奇数)以及最前面几位都是1(让数字最大)，然后中间填0即可。

```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int yi = 0;
        int ling = 0;
        
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == '0') ling ++;
            else yi ++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(yi >= 2){
            sb.append("1");
            yi --;
        }
        
        while(ling > 0){
            sb.append("0");
            ling --;
        }
        
        sb.append("1");
        
        return sb.toString();
    }
}
```