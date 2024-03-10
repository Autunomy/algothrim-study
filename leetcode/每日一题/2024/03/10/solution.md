299. 猜数字游戏

```java
class Solution {
    public String getHint(String secret, String guess) {
        int res = 0;
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        for(int i=0;i<secret.length();++i){
            nums1[secret.charAt(i)-'0']++;
        }   
        for(int i=0;i<guess.length();++i){
            nums2[guess.charAt(i)-'0']++;
        }   

        for(int i=0;i<10;++i){
            res += Math.min(nums1[i],nums2[i]);
        }
        int cnt = 0;
        for(int i=0;i<Math.min(secret.length(),guess.length());++i){
            if(secret.charAt(i) == guess.charAt(i)) cnt++;
        }

        res = res - cnt;
        return cnt + "A" + res + "B";
    }   
}
```