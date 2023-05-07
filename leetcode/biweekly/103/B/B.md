# B-[java]简单模拟

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] res = new int[n];
        int[] cnt1 = new int[60];
        int[] cnt2 = new int[60];
        res[n-1] = n;
        for(int i=0;i<n;++i){
            cnt1[a[i]] ++;
            cnt2[b[i]] ++;
            int cnt = 0;
            for(int j=0;j<60;++j){
                if(cnt1[j] == cnt2[j] && cnt1[j] != 0) cnt ++;
            }
            res[i] = cnt;

        }
        return res;
        
    }
}
```