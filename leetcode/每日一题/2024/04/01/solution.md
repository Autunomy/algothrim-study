2810. 故障键盘

```java
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) != 'i') sb.append(s.charAt(i));
            else sb.reverse();
        }

        return sb.toString();
    }
}
```