例题：

给定一个n个点m条边的有向图，图中可能存在重边和自环，所有边权均为正值。

请你求出 1号点到 n 号点的最短距离，如果无法从 1号点走到 n号点，则输出 −1。

第一行包含整数n和m

接下来m行，每行包含三个整数x,y,z，表示存在点x到y的有向边，边长为z

输出一个整数，表示1到n号点的最短距离

如果不存在输出-1

输出样例

```cpp
3 3
1 2 2
2 3 1
1 3 4
```

输出样例

```cpp
3
```

答案

```cpp
#include<iostream>
#include<algorithm>
#include<string.h>
using namespace std;

int n,m;
const int N = 510;
int g[N][N];
int dist[N],st[N];

int dijkstra(){
    memset(dist,0x3f,sizeof(dist));

    dist[1]=0;
    for(int i=0;i<n;++i){
        int t = -1;
        for(int j=1;j<=n;++j){
            if(!st[j] && (t == -1 || dist[j] < dist[t]))
                t=j;
        }
        st[t]=1;
        for(int j=1;j<=n;++j){
            dist[j]=min(dist[j],dist[t]+g[t][j]);
        }
    }
    if(dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];

}

int main(){
    cin>>n>>m;
    memset(g,0x3f,sizeof(g));
    for(int i=0;i<m;++i){
        int a,b,c;
        cin>>a>>b>>c;
        g[a][b] = min(g[a][b],c);
    }
    cout<<dijkstra()<<endl;
    return 0;
}
import java.util.*;
public class Main{
    static int N = 510,n,m, max = 0x3f3f3f3f;
    static int[][] g = new int[N][N];//存每个点之间的距离
    static int[] dist = new int[N];//存每个点到起点之间的距离
    static boolean[] st = new boolean[N];//存已经确定了最短距离的点
    public static int dijkstra(){
        Arrays.fill(dist,max);//将dist数组一开始赋值成较大的数
        dist[1] = 0; //首先第一个点是零

        //从0开始,遍历n次，一次可以确定一个最小值
        for(int i = 0 ; i < n ; i ++ ){ 
            int t = -1; //t这个变量,准备来说就是转折用的
            for(int j = 1 ; j <= n ; j ++ ){
                /***
                 * 因为数字是大于1的，所以从1开始遍历寻找每个数
                 * 如果s集合中没有这个数
                 * 并且t == -1，表示刚开始 或者 后面的数比我心找的数距离起点的距离短
                 * 然后将j 的值赋值给 t
                 ***/
                if(!st[j] && (t == -1 || dist[j] < dist[t])){
                    t = j; 
                }
            }

            st[t] = true;//表示这个数是已经找到了确定了最短距离的点

            //用已经确认的最短距离的点来更新后面的点
            //就是用1到t的距离加上t到j的距离来更新从1到j的长度
            for(int j = 1 ; j <= n ; j ++ ){
                //
                dist[j] = Math.min(dist[j],dist[t] + g[t][j]);
            }
        }
        //如果最后n的长度没有改变，输出-1，没有找到；否则输出最短路n
        if(dist[n] == max) return -1;
        else return dist[n];

    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        //将他们每个点一开始赋值成一个较大的值
        for(int i = 1 ; i <= n ; i ++ ){
            Arrays.fill(g[i],max);
        }
        while(m -- > 0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            g[a][b] = Math.min(g[a][b],c);//这个因为可能存在重边，所以求出最短的
        }
        int res = dijkstra();
        System.out.println(res);
    }
}
```

| 题目                                                         | 题解                                          |
| ------------------------------------------------------------ | --------------------------------------------- |
| [Dijkstra求最短路 I](https://www.acwing.com/problem/content/851/) | https://www.acwing.com/solution/content/5806/ |
| [Dijkstra求最短路 II](https://www.acwing.com/problem/content/852/) | https://www.acwing.com/solution/content/6554/ |
| [设计可以求最短路径的图类](https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/) | http://www.autunomy.top/solution/content/220  |
| [前往目标的最小代价](https://leetcode.cn/problems/minimum-cost-of-a-path-with-special-roads/description/) | http://www.autunomy.top/solution/content/275  |