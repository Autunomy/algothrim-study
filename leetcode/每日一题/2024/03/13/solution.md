2864. 最大二进制奇数

```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();

        int oneNum = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == '1') oneNum ++;
        }
        StringBuilder sb = new StringBuilder();
        while(oneNum > 1){
            sb.append('1');
            oneNum --;
        }

        int temp = sb.length();
        while(temp < len - 1){
            sb.append('0');
            temp ++;
        }

        sb.append('1');

        return sb.toString();
    }
}
```