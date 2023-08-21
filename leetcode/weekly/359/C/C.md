```java
//如果不买 f[i + 1] = f[i]
//买    f[i + 1] = Math.max(f[i + 1],f[start] + gold) 
// f[i + 1] 表示编号不超过i可以获取的最大价值
class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] f = new int[n + 1];

        Map<Integer,List<List<Integer>>> map = new HashMap<>();

        for(List<Integer> offer : offers){
            if(map.get(offer.get(1)) == null) map.put(offer.get(1),new ArrayList<>());
            map.get(offer.get(1)).add(offer);
        }

        for(int i=0;i<n;++i){
            f[i + 1] = f[i];
            if(map.get(i) != null){
                for(List<Integer> list : map.get(i)){
                    f[i + 1] = Math.max(f[i + 1],f[list.get(0)] + list.get(2));
                }
            }
        }

        return f[n];
    }
}
```