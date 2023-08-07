直接利用`StringBuilder`类的`reverse`方法即可
```java
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) != 'i') sb.append(s.charAt(i));
            else sb.reverse();
        }

        return sb.toString();
    }
}
```