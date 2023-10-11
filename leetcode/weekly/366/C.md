[灵神题解](https://leetcode.cn/problems/apply-operations-to-make-two-strings-equal/)

```java
class Solution {
    public int minOperations(String s1, String s2, int x) {
        if (s1.equals(s2)) {
            return 0;
        }
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                p.add(i);
            }
        }
        if (p.size() % 2 != 0) {
            return -1;
        }
        int f0 = 0, f1 = x;
        for (int i = 1; i < p.size(); i++) {
            int newF = Math.min(f1 + x, f0 + (p.get(i) - p.get(i - 1)) * 2);
            f0 = f1;
            f1 = newF;
        }
        return f1 / 2;
    }
}
```