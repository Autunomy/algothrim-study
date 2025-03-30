2712. 使所有字符相等的最小成本

遍历字符串，如果当前字符和前一个字符不同，就需要将前面所有的字符扭转一次做为当前的成本，如果下一个字符仍然与当前字符不同，则下一个字符的成本是当前字符成本+下一个字符的成本，一次类推。
因为每次遍历到一个字符的时候我们都认为前面所有的字符已经是全部都相等了。
从左到右和从右到左分别遍历一遍，对应位置相加求最小值即可。


```java
class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        long[] left = new long[n];
        long[] right = new long[n];

        for(int i = 1;i < n; ++ i) {
            if(s.charAt(i) != s.charAt(i-1)) {
                left[i] = left[i-1] + i;
            } else {
                left[i] = left[i-1];
            }
        }

        for(int i = n-2;i >= 0; -- i) {
            if(s.charAt(i) != s.charAt(i+1)) {
                right[i] = right[i+1] + n - i - 1;
            } else {
                right[i] = right[i+1];
            }
        }
        long res = Long.MAX_VALUE;

        for(int i = 0 ; i < n; ++ i) {
            res = Math.min(res, left[i] + right[i]);
        }

        return res;

    }
}
```