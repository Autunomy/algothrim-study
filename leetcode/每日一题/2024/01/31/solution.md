2670. 找出不同元素数目差数组

```java
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        int[] cnt1 = new int[n];
        int[] cnt2 = new int[n];
        for(int i=0;i<n;++i){
            s.add(nums[i]);
            cnt1[i] = s.size();
        }
        s = new HashSet<>();
        for(int i=n-1;i>=0;--i){
            cnt2[i] = s.size();
            s.add(nums[i]);
            
            // System.out.println(cnt2[i]);
        }
        
        // for(int i=0;i<n;++i) System.out.println(cnt2[i]);
        int[] res = new int[n];
        for(int i=0;i<n;++i){
            res[i] = cnt1[i]-cnt2[i];
        }
        
        return res;
    }
    
}
```