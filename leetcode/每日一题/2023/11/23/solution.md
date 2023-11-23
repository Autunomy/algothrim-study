1410. HTML 实体解析器

```java
class Solution {
    public String entityParser(String text) {
        Map<String,String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");

        char[] arr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < arr.length){
            if(arr[i] == '&'){
                int j = i + 1;
                String str = "&";
                while(j < arr.length && arr[j] != ';' && arr[j] != '&'){
                    str += arr[j ++];
                }
                if(j < arr.length && arr[j] == ';') str += ';';
                
                if(map.get(str) != null) {
                    sb.append(map.get(str));
                    i = j + 1;
                }else {
                    sb.append(arr[i]);
                    i ++;
                }
            }else{
                sb.append(arr[i ++ ]);
            }
        }

        return sb.toString();
    }
}
```