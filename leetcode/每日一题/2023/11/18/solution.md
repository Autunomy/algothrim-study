2342. 数位和相等数对的最大和

```java
class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] sum = new int[n];

        for(int i=0;i<n;++i){
            int temp = nums[i];
            while(temp != 0){
                sum[i] += temp % 10;
                temp /= 10;
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for(int i=n-1;i>=0;--i){
            if(map.get(sum[i]) != null){
                max = Math.max(max,nums[i] + nums[map.get(sum[i])]);
            }

            map.put(sum[i],i);
        }

        return max;
    }
}
```