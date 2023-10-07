901. 股票价格跨度

单调栈
```java
class StockSpanner {
    List<int[]> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        if(list.size() == 0) {
            list.add(new int[]{price,1});
            return 1;
        }else{
            int res = 1;
            if(list.get(list.size()-1)[0] <= price){
                for(int i=list.size()-1;i>=0;){
                    if(list.get(i)[0] <= price){
                        res += list.get(i)[1];
                        i -= list.get(i)[1];
                    }else break;
                }
            }
            list.add(new int[]{price,res});
            return res;
        }
    }
}
```