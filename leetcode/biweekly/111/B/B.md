```java
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length() < str2.length()) return false;
        int cnt = 0;
        for(int i=0;i<str2.length();++i){
            char x = str2.charAt(i);//原字符
            char c = str2.charAt(i);//减一后的字符
            if(c == 'a') c = 'z';
            else c = (char)(c - 1);
            //如果没有找到x和c其中的任何一个就++ 直到遍历完str1
            while(cnt < str1.length() && str1.charAt(cnt) != c && str1.charAt(cnt) != x) cnt++;
            
            //str1遍历完了就返回false
            if(cnt == str1.length()) return false;
            else cnt ++;

        }

        return true;
    }
}
```