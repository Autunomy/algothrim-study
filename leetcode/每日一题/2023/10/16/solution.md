260. 只出现一次的数字 III

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i=0;i<nums.length;++i){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(cnt == 2) break;
            if(entry.getValue() == 1){
                res[cnt ++] = entry.getKey();
            }
        }

        return res;
    }
}
```