思路：简单分析可以，一定可以通过若干次操作将所有相同的字符删除到只剩下一个，所以只需要统计不同字符的数量就是答案

```java
class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();

        for(int i=0;i<n;++i) set.add(s.charAt(i));

        return set.size();
    }
}
```