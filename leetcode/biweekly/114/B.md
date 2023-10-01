使用hash表保存每种数字的出现次数，如果小于2就无法删除，返回-1
因为要最少次数所以尽量删除3个相同的来快速删除
1. 能除尽3 可以直接让出现次数除以3并累加到答案中
2. 除3模2  模的2可以通过增加一次删除2个相同的元素的操作来删除，所以让val/3 + 1即可
3. 除3模1  需要取消一次删除3个元素的操作，增加两次删除2个元素的操作


```java
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;++i) map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() < 2){
                return -1;
            }
            int val = entry.getValue();
            if(val % 3 == 0) res += val / 3;
            else if(val % 3 == 2) res += val / 3 + 1;
            else res += val / 3 + 1;
        }
        return res;
    }
}
```