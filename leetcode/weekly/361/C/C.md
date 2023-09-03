前缀和+公式+变形
```java
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        //将 % modulo == k的都标记为1
        for(int i=0;i<n;++i){
            if(nums.get(i) % modulo == k){
                arr[i] = 1;
            }
        }

        int[] s = new int[n + 1];
        for(int i=0;i<n;++i){
            s[i + 1] = arr[i] + s[i];
        }

        // 不需要补 modulo 也就是结果不会出现负数
        // (s[R + 1] - s[L]) % modulo = k 
        // => s[R + 1] % modulo - s[L] % modulo = k
        // => s[R + 1] % modulo - k = s[L] % modulo
        // 需要补 modulo  结果会出现负数需要补m使答案正确
        // => s[R + 1] % modulo - k + modulo = s[L] % modulo
        // => (s[R + 1] % modulo - k + modulo) % modulo = s[L] % modulo
        long res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n+1;++i){
            res += map.getOrDefault((s[i] % modulo - k + modulo) % modulo,0);
            map.put(s[i] % modulo,map.getOrDefault(s[i] % modulo,0) + 1);
        }
 
        return res;
    }
}
```