思路：双指针，遇到不同的都变为两个字符中最小的即可

```java
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0,j = n-1;
        while(i < j){
            if(arr[i] != arr[j]){
                if(arr[i] > arr[j]){
                    arr[i] = arr[j];
                }else{
                    arr[j] = arr[i];
                }
            }
            i++;
            j--;
        }
        
        return new String(arr);
    }
}
```