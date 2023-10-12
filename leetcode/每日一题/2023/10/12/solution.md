2562. 找出数组的串联值
```java
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i=0,j=nums.length-1;
        while(i <= j){
            if(i == j){
                res += nums[i];
                i++;
                j--;
            }else{
                String temp = nums[i] + "" + nums[j];
                res += Integer.valueOf(temp);
                i++;
                j--;
            }
        }
        return res;
    }
}
```