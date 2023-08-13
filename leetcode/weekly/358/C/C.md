```java
/*
    思路就是从前向后遍历每个数字，同时维护一个TreeSet，这个TreeSet中放的数字是距离当前数字的距离大于等于x的全部数字。我们可以在最开始的时候对这个TreeSet进行初始化，初始化为[x,n-1]的数字。注意这里还需要使用一个map记录每个数字的出现次数，防止出现相同数字导致被TreeSet去重。
    之后从第一个数字开始向后遍历，每次使用TreeSet的方法去获取大于等于和小于等于当前数字的数，并进行比较，最后更新答案即可
*/
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        //特判一下
        if(x == 0) return 0;
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int left = 0;
        int right = x;
        int res = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = x;i<n;++i){
            // res = Math.min(res,Math.abs(nums.get(i) - nums.get(0)));
            set.add(nums.get(i));//将后面的[x,n-1]的所有数字加入set中
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);//统计每个数字的出现次数
        }

        //开始遍历
        while(right < n){
            //当前数字
            int num = nums.get(left);
            //找到大于等于num的数字
            if(set.ceiling(num) != null) {
                res = Math.min(res,Math.abs(set.ceiling(num) - num));
            }
            //找到小于等于num的数字
            if(set.floor(num) != null) {
                res = Math.min(res,Math.abs(set.floor(num) - num));
            }

            //如果出现次数为0才能删除
            if(map.get(nums.get(right)) == 1) set.remove(nums.get(right));
            else map.put(nums.get(right),map.get(nums.get(right))-1);
            left ++;
            right ++;
        }

        return res;
    }
}
```