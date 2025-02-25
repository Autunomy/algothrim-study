1656. 设计有序流

简单模拟题


```java
class OrderedStream {

    String[] arr;
    int ptr = 1;

    public OrderedStream(int n) {
        arr = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        arr[idKey] = value;

        if (idKey == ptr) {
            while(ptr < arr.length && arr[ptr] != null) {
                res.add(arr[ptr]);
                ptr++;
            }
        }

        return res;
    }
}
```