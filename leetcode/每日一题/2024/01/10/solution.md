2696. 删除子串后的字符串最小长度

```java
class Solution {
    public int minLength(String s) {
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();++i) list.add(s.charAt(i));
        int cnt = 0;
        while(true){
            boolean flag = true;
            List<Character> temp = new ArrayList<>();
            for(int i=0;i<list.size();){
                if(i + 1 < list.size() && ("AB".equals("" + list.get(i) + list.get(i+1)) || "CD".equals("" + list.get(i) + list.get(i+1)))){
                    flag = false;
                    i+=2;
                    cnt++;
                }else{
                    temp.add(list.get(i));
                    i++;
                }
            }
            list = temp;
            
            
            if(flag){
               return temp.size(); 
            }
        }
    }
}
```