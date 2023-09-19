对于每个机器，二分一下最终的答案，然后更新一下最终的res即可

闭区间写法
```java
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        //当需要金属数量为1且价格为1的时候可以造最多的合金，数量就是stock中数量最少的合金(短板)+budget
        int max = Collections.min(stock) + budget;

        for(List<Integer> com : composition){
            int left = 0,right = max;

            while(left < right){
                int mid = (left + right + 1) >> 1;
                long sumMoney = 0;
                boolean flag = true;
                for(int i=0;i<com.size();++i){
                    //如果一开始拥有的金属数量<需要的数量就需要额外购买
                    if(stock.get(i) < (long)com.get(i) * mid){
                        sumMoney += cost.get(i) * ((long)com.get(i) * mid - stock.get(i));
                    }
                    //如果金额超标了，就直接退出循环
                    if(sumMoney > (long)budget){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    left = mid;
                }else{
                    right = mid - 1;
                }
            }

            res = Math.max(res,left);
        }

        return res;
    }
}
```

开区间写法
```java
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        //当需要金属数量为1且价格为1的时候可以造最多的合金，数量就是stock中数量最少的合金(短板)+budget
        int max = Collections.min(stock) + budget;

        for(List<Integer> com : composition){
            int left = 0,right = max + 1;

            while(left + 1 < right){
                int mid = (left + right) / 2;
                long sumMoney = 0;
                boolean flag = true;
                for(int i=0;i<com.size();++i){
                    //如果一开始拥有的金属数量<需要的数量就需要额外购买
                    if(stock.get(i) < (long)com.get(i) * mid){
                        sumMoney += cost.get(i) * ((long)com.get(i) * mid - stock.get(i));
                    }
                    if(sumMoney > (long)budget){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    left = mid;
                }else{
                    right = mid;
                }
            }

            res = Math.max(res,left);
        }

        return res;
    }
}
```