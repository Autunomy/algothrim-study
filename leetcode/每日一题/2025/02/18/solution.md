[2080]区间内查询数字的频率

二分查找

```java
class RangeFreqQuery {

    Map<Integer, List<Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) { 
        int n = arr.length;
        for(int i = 0; i < arr.length; ++ i) {
            if(map.get(arr[i]) == null) map.put(arr[i], new ArrayList<>());

            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if (map.get(value) == null) {
            return 0;
        }

        return lowerBound(map.get(value), right + 1) - lowerBound(map.get(value), left);
    }

    public int lowerBound(List<Integer> list, int value) {

        int left = -1, right = list.size();

        while(left + 1 < right) {
            int mid = (left + right) >>> 1;

            if (list.get(mid) < value) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
```