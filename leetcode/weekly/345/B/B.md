思路：固定第一位元素为0或1，然后模拟出来一个original，判断是否满足条件即可

```java
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] o1 = new int[n];//第一位为0
        int[] o2 = new int[n];//第一位为1
        o1[0] = 0;
        o2[0] = 1;
        
        for(int i=0;i<n-1;++i){
            if(derived[i] == 0){
                o1[i+1] = o1[i];
            }else{
                o1[i+1] = (o1[i]+1)%2;
            }
        }
        boolean flag = false;
        //是否满足条件
        if((o1[n-1] ^ o1[0]) == derived[n-1]) flag = true;
        
        for(int i=0;i<n-1;++i){
            if(derived[i] == 0){
                o2[i+1] = o2[i];
            }else{
                o2[i+1] = (o2[i]+1)%2;
            }
        }
        //是否满足条件
        if((o2[n-1] ^ o2[0]) == derived[n-1]) flag = true;
        
        return flag;
    }
}
```