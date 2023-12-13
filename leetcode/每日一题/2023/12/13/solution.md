2697. 字典序最小回文串

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