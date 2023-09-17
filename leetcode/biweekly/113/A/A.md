从0开始枚举起点，然后在判断是否递增

```java
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        for(int i=0;i<n;++i){
            int temp = n - 1;
            int last = nums.get(i);
            int j = i + 1;
            boolean flag = true;
            while(temp -- > 0){
                if(j == n) j = 0;
                if(nums.get(j) <= last) {
                    flag = false;
                    break;
                }
                else last = nums.get(j);
                j++;
            }
            if(flag) return (n - i) % n;
        }

        return -1;
    }
}
```