```java
class Solution {
    public int minimumSum(int n, int k) {
        int res = 0;
        int cnt = 0;
        int[] arr = new int[1000];
        for(int i=0;i<1000;++i) arr[i] = i;

        //将求和为k且偏大的数置为0  表示不选
        for(int i=1;i<=k;++i){
            if(arr[i] != 0 && i != k-arr[i])
                arr[k-arr[i]] = 0;
        }   

        int idx = 1;

        //取得n个数的和
        while(cnt < n){
            if(arr[idx] != 0) {
                res += arr[idx];
                cnt ++;
            }

            idx ++;
        }

        return res;
    }
}
```