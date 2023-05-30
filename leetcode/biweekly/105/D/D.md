思路：使用一个并查集，将每个数与它对应的所有**质因子**进行合并，最后任意选取一个nums中的数，找其fa，然后判断剩下的节点，如果fa相同返回true,fa不同返回false

```java
class Solution {

    int[] fa;
    //查询
    int find(int x){
        if(fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

    //合并
    void merge(int x,int y){
        x = find(x);
        y = find(y);

        if(x != y){
            fa[x] = y;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int max = 0;
        int n = nums.length;
        if(n == 1) return true;
        for(int i=0;i<n;++i){
            max = Math.max(nums[i],max);
        }
        //存放每个数的质因子，这是线性筛的写法，想要更快可以使用一些高级筛法
        List<Integer>[] zhi = new List[max + 1];
        for(int i=0;i<max + 1;++i) zhi[i] = new ArrayList<>();

        for(int i=2;i<max + 1;++i){
            if(zhi[i].size() == 0){
                for(int j=i;j<max+1;j+=i){
                    zhi[j].add(i);
                }
            }
        }

        //并查集
        fa = new int[1000000];
        for(int i=0;i<1000000;++i) fa[i] = i;

        //将nums的元素与其对应的质因子合并
        for(int i=0;i<n;++i){
            if(nums[i] == 1) return false;
            for(int j : zhi[nums[i]]){
                merge(nums[i],j);
            }
        }

        //判断是否满足条件
        int temp = find(nums[0]);
        for(int i=0;i<n;++i){
            if(find(nums[i]) != temp){
                return false;
            }
        }

        return true;

    }
}
```