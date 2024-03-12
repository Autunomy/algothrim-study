2129. 将标题首字母大写

```java
public class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        for (String s : title.split(" ")) {
            if (!ans.isEmpty()) {
                ans.append(' ');
            }
            if (s.length() > 2) {
                ans.append(s.substring(0, 1).toUpperCase()); // 首字母大写
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }
}
```