[灵神题解](https://leetcode.cn/problems/string-transformation/solutions/2435348/kmp-ju-zhen-kuai-su-mi-you-hua-dp-by-end-vypf/)

```java
class Solution {
    public int numberOfWays(String s, String t, long k) {
        int n = s.length();
        int c = kmpSearch(s + s.substring(0, n - 1), t);
        long[][] m = {
            {c - 1, c},
            {n - c, n - 1 - c},
        };
        m = pow(m, k);
        return s.equals(t) ? (int) m[0][0] : (int) m[0][1];
    }

    // KMP 模板
    private int[] calcMaxMatch(String s) {
        int[] match = new int[s.length()];
        int c = 0;
        for (int i = 1; i < s.length(); i++) {
            char v = s.charAt(i);
            while (c > 0 && s.charAt(c) != v) {
                c = match[c - 1];
            }
            if (s.charAt(c) == v) {
                c++;
            }
            match[i] = c;
        }
        return match;
    }

    // KMP 模板
    // 返回 text 中出现了多少次 pattern（允许 pattern 重叠）
    private int kmpSearch(String text, String pattern) {
        int[] match = calcMaxMatch(pattern);
        int lenP = pattern.length();
        int matchCnt = 0;
        int c = 0;
        for (int i = 0; i < text.length(); i++) {
            char v = text.charAt(i);
            while (c > 0 && pattern.charAt(c) != v) {
                c = match[c - 1];
            }
            if (pattern.charAt(c) == v) {
                c++;
            }
            if (c == lenP) {
                matchCnt++;
                c = match[c - 1];
            }
        }
        return matchCnt;
    }

    private static final long MOD = (long) 1e9 + 7;

    // 矩阵乘法
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (a[i][0] * b[0][j] + a[i][1] * b[1][j]) % MOD;
            }
        }
        return c;
    }

    // 矩阵快速幂
    private long[][] pow(long[][] a, long n) {
        long[][] res = {{1, 0}, {0, 1}};
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = multiply(res, a);
            }
            a = multiply(a, a);
        }
        return res;
    }
}
```