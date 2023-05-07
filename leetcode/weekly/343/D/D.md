# D-[java]贪心+字符串+思维题

```java
/*
长度超过2的回文字符串的判断方法
1.当前位置等于前一个字符
2.当前位置等于前前一个字符
*/

class Solution {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = n-1;
        //最开始需要先给最后一个字符+1,使其变的比原字符串大
        arr[i] += 1;
        while(i >= 0 && i < n){
            //表示需要进位(arr[i]只能到arr[i] + k - 1的位置)
            if(arr[i] == 'a' + k){
                //i已经到了第一个位置 无法再向前进位了 那么就没有合法字符串 直接返回空字符串
                if(i == 0) return "";
                //当前位设置为'a'
                arr[i] = 'a';
                i--;
                //前一位的字母+1
                arr[i] += 1; 
            }else if(i > 0 && arr[i] == arr[i-1] || i > 1 && arr[i] == arr[i-2]){//产生了长度大于1的回文字符串
                arr[i] += 1;//继续给当前位进1，防止产生回文字符串
            }else i++;//当前位置不会产生回文字符 那么继续处理后面的字符串
        }

        return new String(arr);
    }
}
```