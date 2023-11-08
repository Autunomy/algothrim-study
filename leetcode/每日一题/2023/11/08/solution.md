2609. 最长平衡子字符串

```java
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zeroNum = 0;
        int oneNum = 0;
        int res = 0;
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(c == '0' && oneNum == 0) zeroNum ++;
            else if(c == '1'){
                oneNum ++;
                res = Math.max(res,Math.min(zeroNum,oneNum)*2);  
            }else{
                zeroNum = 1;
                oneNum = 0;
            }
        }
        return res;
    }
}
```