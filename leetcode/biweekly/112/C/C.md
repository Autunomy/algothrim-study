使用map来存储每个元素的数量，map的size就是不同元素的数量，然后开一个长度为k的滑动窗口然后不断更新sum以及res即可

```java
class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.size();
        long sum = 0;
        int left = 0,right = 0;
        while(right < k){
            map.put(nums.get(right),map.getOrDefault(nums.get(right),0) + 1);
            sum += (long)nums.get(right);
            right ++;
        }
        right --;
        long res = 0;
        while(right < n){
            if(map.size() >= m){
                res = Math.max(res,sum);
            }
            if(map.get(nums.get(left)) != null) map.put(nums.get(left),map.get(nums.get(left)) - 1);
            if(map.get(nums.get(left)) != null && map.get(nums.get(left)) == 0) map.remove(nums.get(left));
            sum -= nums.get(left);
            
            left ++;
            right ++;
            
            
            if(right < n){
                sum += nums.get(right);
                map.put(nums.get(right),map.getOrDefault(nums.get(right),0) + 1);
            }
        }
        
        if(map.size() >= m){
            res = Math.max(res,sum);
        }
        return res;
    }
}
```