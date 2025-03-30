2109. 向字符串添加空格

```java
class Solution {
    public String addSpaces(String s, int[] spaces) {
        int idx = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < spaces.length; ++ i) {
            sb.append(s.substring(idx, spaces[i]) + " ");
            idx = spaces[i];
        }
        sb.append(s.substring(idx, n));

        return sb.toString();
    }
}
```