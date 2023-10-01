使用一个hash表保存每次弹出的元素，判断hash表大小是否等于k即可

```java
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=nums.size() - 1;i>=0;--i){
            if(nums.get(i) <= k) set.add(nums.get(i));
            if(set.size() == k){
                return nums.size() - i;
            }
        }
        return 0;
    }
}
```