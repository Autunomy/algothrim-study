```java
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.size();++i){
            if(map.get(nums.get(i)) == null) map.put(nums.get(i),new ArrayList<>());

            map.get(nums.get(i)).add(i);
        }

        int res = 0;

        //使用滑动窗口来判断中间可以产生的最长子数组的长度
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();

            int left = 0,right = 0;
            while(right < list.size()){
                while(left <= right && list.get(right) - list.get(left) - (right - left) > k){
                    left ++;
                }
                res = Math.max(res,right - left + 1);
                right ++;
            }
        }

        return res;
    }
}
```