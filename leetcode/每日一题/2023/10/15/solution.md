137. 只出现一次的数字 II

hash表暴力即可

```java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;++i){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return 0;
    }
}
```