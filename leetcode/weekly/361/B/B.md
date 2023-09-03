能被25整除一定是
- 结尾为{00,25,50,75}
- 整个数字为0
- 数字不存在

那么就暴力判断即可

```java
class Solution {
    public int minimumOperations(String num) {
        String[] arr = new String[]{"00","52","57","05"};
        int n = num.length();
        int res = Integer.MAX_VALUE;
        for(int i=0;i<4;++i){
            int cnt = 0;
            int idx = 0;
            for(int j=n - 1;j >= 0; --j){
                if(num.charAt(j) == arr[i].charAt(idx)){
                    idx ++;
                    if(idx == 2){
                        res = Math.min(res,cnt);
                        break;
                    }
                }else{
                    cnt ++;
                }
                // cnt ++;
            }
        }
        
        if(num.indexOf("0") != -1){
            res = Math.min(res,n - 1);
        }
        
        res = Math.min(res,n);
        
        return res;
        
    }
}
```