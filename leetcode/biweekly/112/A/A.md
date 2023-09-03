分别判断1 3两个位置的元素对应是否相等，不相等就执行交换，然后判断两个字符串是否相等


```java
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        if(arr1[0] != arr2[0]){
            char c = arr1[0];
            arr1[0] = arr1[2];
            arr1[2] = c;
        }
        
        if(arr1[1] != arr2[1]){
            char c = arr1[1];
            arr1[1] = arr1[3];
            arr1[3] = c;
        }
        
        for(int i=0;i<4;++i){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
```