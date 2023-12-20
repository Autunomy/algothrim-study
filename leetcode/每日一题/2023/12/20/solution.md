2828. 判别首字母缩略词

```java
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<words.size();++i){
            sb.append(words.get(i).charAt(0));
        }

        return sb.toString().equals(s);
    }
}
```