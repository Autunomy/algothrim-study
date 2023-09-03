暴力枚举
```java
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i=low;i<=high;++i){
            int cnt1 = 0;
            int cnt2 = 0;
            int n = 0;
            int temp = i;
            while(temp > 0) {
                n ++;
                temp /= 10;
            }
            temp = i;
            if(n % 2 == 0){
                n /= 2;
                for(int j=0;j<n;++j){
                    cnt1 += temp % 10;
                    temp /= 10;
                }
                for(int j=0;j<n;++j){
                    cnt2 += temp % 10;
                    temp /= 10;
                }
                if(cnt1 == cnt2) res++;
            }
        }
        return res;
    }
}
```