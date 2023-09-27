1333. 餐厅过滤器
简单的一个暴力枚举以及双关键字排序

```java
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<restaurants.length;++i){
            if((veganFriendly == 1 && restaurants[i][2] == 1) || veganFriendly == 0){
                if(restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance){
                    
                    list.add(new int[]{restaurants[i][0],restaurants[i][1]});
                }
            }
        }
        Collections.sort(list,(o1,o2) -> (o2[1] - o1[1] == 0?o2[0] - o1[0]:o2[1] - o1[1]));
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<list.size();++i){
            res.add(list.get(i)[0]);
        }
        return res;
    }
}
```