2808. 使循环数组所有元素相等的最少秒数

```java
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;++i){
            if(map.get(nums.get(i)) == null) map.put(nums.get(i),new ArrayList<>());
            map.get(nums.get(i)).add(i);
        }
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            Collections.sort(list);

            int max = list.get(0) + n - list.get(list.size() - 1) - 1;

            for(int i=1;i<list.size();++i){
                max = Math.max(list.get(i) - list.get(i - 1) - 1,max);
            }
            int cnt = max > 0?1:0;
            max -= 2;
    
            if(max > 0) cnt += (max + 1) / 2;//上取整
            res = Math.min(res,cnt);
        }
        return res;
    }
}
```