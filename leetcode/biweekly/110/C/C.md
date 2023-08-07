只需要将所有相同数字的下标保存起来，然后求将数组同化每种数字所需要的最小秒数即可
每种数字的同化时间可以用两个相同元素之间元素数量的最大值来求得，具体查看代码



```java
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        //存储每种值对应的下标位置
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;++i){
            if(map.get(nums.get(i)) == null) map.put(nums.get(i),new ArrayList<>());
            map.get(nums.get(i)).add(i);
        }
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            //排
            Collections.sort(list);

            //第一个位置之前与最后一个位置之后所包含的元素(循环数组，所以这两个值是相邻元素)
            int max = list.get(0) + n - list.get(list.size() - 1) - 1;

            //求相邻位置之间元素数量的最大值
            for(int i=1;i<list.size();++i){
                max = Math.max(list.get(i) - list.get(i - 1) - 1,max);
            }

            //求需要的时间
            int cnt = max > 0?1:0;
            max -= 2;
    
            if(max > 0) cnt += (max + 1) / 2;//上取整
            res = Math.min(res,cnt);
        }
        return res;
    }
}
```