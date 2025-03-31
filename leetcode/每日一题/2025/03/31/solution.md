2278. 字母在字符串中的百分比

```java
class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                ++cnt;
            }
        }
        return 100 * cnt / n;
    }
}
```