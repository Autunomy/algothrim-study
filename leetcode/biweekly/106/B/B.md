思路：滑动窗口，用一个cnt记录当前有几对相邻字符相同。当cnt>1的时候就将left向右移动，直到cnt == 1

```java
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int res = 0;
        
        int cnt = 0;
        int left = 0;
        int right = 1;

        while(right < n){
            if(s.charAt(right) == s.charAt(right - 1)){
                cnt ++;
                if(cnt > 1){
                    while(left < right){
                        if(s.charAt(left) == s.charAt(left+1)){
                            cnt--;
                            left++;
                            break;
                        }
                        left++;
                    }
                }
            }
            res = Math.max(res,right - left + 1);
            right ++;
        }
        res = Math.max(res,right - left);
        return res;
    }
}
```