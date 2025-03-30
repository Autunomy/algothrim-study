2255. 统计是给定字符串前缀的字符串数目

```java
class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(int i = 0; i < words.length; ++ i) {
            if(s.startsWith(words[i])) res ++;
        }

        return res;
    }
}
```