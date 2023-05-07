# A

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
        }
        
        int[] res = new int[n];
        for(int i=0;i<n;++i){
            res[i] = cnt1[i]-cnt2[i];
        }   
        return res;
    }
}
```

# B

```java
class FrequencyTracker {
    //统计出现次数的出现次数
    Map<Integer,Integer> map = new HashMap<>();
    int[] cnt = new int[200010];//统计出现次数
    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        if(map.get(cnt[number]) != null && map.get(cnt[number]) >= 1) map.put(cnt[number],map.get(cnt[number])-1);
        cnt[number] ++;
        map.put(cnt[number],map.getOrDefault(cnt[number],0) + 1);
    }
    
    public void deleteOne(int number) {
        if(cnt[number] > 0){
            map.put(cnt[number],map.get(cnt[number])-1);
            cnt[number] --;
            map.put(cnt[number],map.getOrDefault(cnt[number],0) + 1);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        if(map.get(frequency) != null && map.get(frequency) > 0) return true;
        return false;
    }
}
```

# C

使用一个变量cnt记录当前整个数组中相等的对数，每次修改一个格子的颜色只会影响到其相邻的两个格子，只需要判断相邻两个格子与当前格子即可

```java
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
	int[] nums = new int[n];
        int cnt = 0;
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;++i){
            int idx = queries[i][0];
            int c = queries[i][1];
            
            //如果旧颜色不为0
            if(nums[idx] != 0){
                //如果旧颜色与后面的颜色相同 那么就先让对数-1
                if(idx+1 < n && nums[idx] == nums[idx+1]) cnt--;
                //如果旧颜色与前面的颜色相同 那么就先让对数-1
                if(idx-1 >= 0 && nums[idx] == nums[idx-1]) cnt--;
            }
            //修改颜色
            nums[idx] = c;
            //如果新颜色与后面的颜色相同 那么就让对数+1
            if(idx+1 < n && nums[idx] == nums[idx+1]) cnt++;
            //如果新颜色与前 面的颜色相同 那么就让对数+1
            if(idx-1 >= 0 && nums[idx] == nums[idx-1]) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}
```

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