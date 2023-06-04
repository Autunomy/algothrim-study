思路：通过观察发现后面如果有一个操作会修改第i行，那么前面修改第i行所有的操作都是没有意义的操作。根据这个思路，从后向前遍历queries数组，每次都将修改的行或列进行记录，如果后面再次修改，直接跳过

```java
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i=0;i<n;++i) {
            row.add(i);
            col.add(i);
        }
        long res = 0L;
        for(int i=queries.length-1;i>=0;--i){
            int t = queries[i][0];
            int idx = queries[i][1];
            int v = queries[i][2];
            if(t == 0){
                if(row.contains(idx))//没有被修改过才能被修改
                    res += (long)v * col.size();
                row.remove(idx);
            }else{
                if(col.contains(idx))
                    res += (long)v * row.size();
                col.remove(idx);
            }
        }   
        return res;
    }
}
```