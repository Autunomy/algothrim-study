```java
/*
    贪心思想
    从1开始向后找，设置一个hash表存储能够与之前被选过的元素之和形成target的数，之后就不能选择的
*/
class Solution {
    public long minimumPossibleSum(int n, int target) {
        long res = 0;

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        while(list.size() < n){
            if(set.contains(cnt)){
                cnt++;
                continue;
            }
            set.add(target - cnt);
            list.add(cnt);
            res += (long)cnt;
            cnt++;
        }

        return res;
    }
}
```