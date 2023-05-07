# C-[java]Dijkstra+单源最短路径

```java
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        //使用long的前32位存储终点的x，后32位存储终点的y
        long t = (long)target[0] << 32 | target[1];
        //dis[i] 表示从start到i的最短距离
        Map<Long,Integer> dis = new HashMap<>();
        //如果一个点已经找到了起点到终点的最小路径就会加入到vis中，防止重复遍历
        Set<Long> vis = new HashSet<>();
        dis.put(t,Integer.MAX_VALUE);//初始化到终点的距离为无穷
        dis.put(((long)start[0] << 32) | start[1] , 0);//起点到起点的距离为0

        while(true){
            //v表示当前的dis中距离start最短的路径的点
            long v = -1L;
            //模板 找dis中距离start距离最短的点
            for(Map.Entry<Long,Integer> e : dis.entrySet()){
                if(!vis.contains(e.getKey()) && (v == -1 || dis.get(v) > e.getValue()))
                    v = e.getKey();
            }
            //说明最短路径已经找到 直接返回
            if(v == t){
                return dis.get(v);
            }
            //加入到最小路径的集合中，防止重复遍历
            vis.add(v);
            //获取到v代表的真实横纵坐标
            int vx = (int)(v >> 32),vy = (int)(v&Integer.MAX_VALUE);
            //更新当前v到终点target的距离
            dis.put(t,Math.min(dis.get(t),dis.get(v)+target[0]-vx+target[1]-vy));
            
            //循环所有的特殊路径并更新一下从start到每个特殊路径终点的最小值
            for(int i=0;i<specialRoads.length;++i){
                int[] s = specialRoads[i];
                int x = s[2],y = s[3];//特殊路径的终点坐标
                //求直接从start到特殊路径的终点的距离 和 从start到特殊路径起点的距离+走特殊路径距离 的最小值
                int d = dis.get(v) + Math.min(Math.abs(vx-x)+Math.abs(vy-y),Math.abs(vx-s[0])+Math.abs(vy-s[1])+s[4]);
                
                long w = (long)x << 32 | y;
                if(d < dis.getOrDefault(w,Integer.MAX_VALUE)){
                    dis.put(w,d);
                }
            }
        }
    }
}
```