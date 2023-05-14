思路：取第11和12位判断组成的数字是否大于60即可

```java
class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for(int i=0;i<details.length;++i){
            int temp = 0;
            for(int j=11;j<=12;++j){
                temp *= 10;
                temp += (details[i].charAt(j)-'0');
            }
            if(temp > 60) cnt++;
        }
        return cnt;
    }
}
```