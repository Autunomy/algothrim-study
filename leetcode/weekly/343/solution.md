# A-[java]阅读理解

这个题目的翻译是真的有问题，看了很长时间都没看懂是只看前两轮还是i前的2轮。最后做出来才知道是i的前两轮

```java
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = 0;
        int sum2 = 0;
        int n = player1.length;
        for(int i=0;i<n;++i){
             sum1 += player1[i];
             sum2 += player2[i];
            
            if(i >= 2){
                if(player1[i-1] == 10 || player1[i-2] == 10) sum1 += player1[i];
                if(player2[i-1] == 10 || player2[i-2] == 10) sum2 += player2[i];
            }else if(i >= 1){
                if(player1[i-1] == 10) sum1 += player1[i];
                if(player2[i-1] == 10) sum2 += player2[i];
            }

        }
        
        if(sum1 > sum2) return 1;
        else if(sum1 < sum2) return 2;
        else return 0;
    }
}
```

# B-[java]阅读理解

这道题翻译的更离谱，完全没有看懂题目说的意思是什么...

题意：找到第一个被涂满的行或者列

用一个数组记录一下每一行和每一列已经图了的数量，判断是否等于行数或者列数即可

```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] cntrow = new int[n];
        int[] cntcol = new int[m];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        
        for(int i=0;i<m*n;++i){
            int[] temp = map.get(arr[i]);
            cntrow[temp[0]] ++;
            cntcol[temp[1]] ++;
            if(cntrow[temp[0]] == m || cntcol[temp[1]] == n) return i;
        }
        return n*m-1;
    }
}
```

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

# D-[java]贪心+字符串+思维题

```java
/*
长度超过2的回文字符串的判断方法
1.当前位置等于前一个字符
2.当前位置等于前前一个字符
*/

class Solution {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = n-1;
        //最开始需要先给最后一个字符+1,使其变的比原字符串大
        arr[i] += 1;
        while(i >= 0 && i < n){
            //表示需要进位(arr[i]只能到arr[i] + k - 1的位置)
            if(arr[i] == 'a' + k){
                //i已经到了第一个位置 无法再向前进位了 那么就没有合法字符串 直接返回空字符串
                if(i == 0) return "";
                //当前位设置为'a'
                arr[i] = 'a';
                i--;
                //前一位的字母+1
                arr[i] += 1; 
            }else if(i > 0 && arr[i] == arr[i-1] || i > 1 && arr[i] == arr[i-2]){//产生了长度大于1的回文字符串
                arr[i] += 1;//继续给当前位进1，防止产生回文字符串
            }else i++;//当前位置不会产生回文字符 那么继续处理后面的字符串
        }

        return new String(arr);
    }
}
```