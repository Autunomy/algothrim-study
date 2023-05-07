# D

将所有路径的路径和都保存在一个list中，两两一组，两个之差加入到答案中之后放入一个新的集合，然后新的集合继续按照上述步骤合并，直到只剩下一个元素就退出。

```java
class Solution {
    List<Integer> list = new ArrayList<>();
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        dfs(1,n,cost,0);
        
        while(list.size() > 1){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<list.size();i+=2){
                res += Math.abs(list.get(i) - list.get(i+1));
                temp.add(Math.max(list.get(i),list.get(i+1)));
            }
            list = temp;
        }
        
        return res;
    }
    
    public void dfs(int root,int n,int[] cost,int sum){
        if(root > n) {
            list.add(sum);
            return;
        }
        
        dfs(root*2,n,cost,sum+cost[root-1]);
        dfs(root*2+1,n,cost,sum+cost[root-1]);
    }
}
```