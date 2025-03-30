2716. 最小化字符串长度

```java
class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() ; ++ i) {
            set.add(s.charAt(i));
        }

        return set.size();
    }
}
```