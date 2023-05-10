原题链接:[https://leetcode.cn/problems/qoQAMX/](https://leetcode.cn/problems/qoQAMX/)

思路:暴力遍历所有路径，每次都对路径进行排序，将字典序小的放在前面,最后去掉后面的1即可

```java
class Solution {
    public String evolutionaryRecord(int[] parents) {
        int n = parents.length;
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=1;i<n;++i){
            if(map.get(parents[i]) == null) map.put(parents[i],new ArrayList<>());

            map.get(parents[i]).add(i);
        }

        //去掉第一个 0 和末尾连续的 1
        return dfs(map,0).substring(1).replaceAll("1+$", "");
    }   

    String dfs(Map<Integer,List<Integer>> map,int x){
        List<String> list = new ArrayList<>();
        for (int y : map.getOrDefault(x, new ArrayList<>())) {
            list.add(dfs(map,y));
        }
        //排序 集合中的每个元素代表走到从当前节点到每一个根节点的字符串
        Collections.sort(list);
        //按照字典序大小，将从小到大依次加入到答案中
        return "0" + String.join("", list) + "1";
    }
}
```