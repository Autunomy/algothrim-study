思路：经典的BFS求最短路，但是如果暴力BFS会TLE，需要进行优化，详见代码

```java
import java.io.*;
import java.util.*;

/**
 * @author hty
 * @email 1156388927@qq.com
 * @description
 * @other 题解及更多请看www.autunomy.top
 */

public class Main {
    private static Kattio sc = new Kattio();
    int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        char[][] g = new char[n][n];
        for(int i=0;i<n;++i) g[i] = sc.next().toCharArray();

        int x1 = sc.nextInt()-1;
        int y1 = sc.nextInt()-1;
        int x2 = sc.nextInt()-1;
        int y2 = sc.nextInt()-1;

        if(x1 == x2 && y1 == y2){
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int i=0;i<n;++i) Arrays.fill(dist[i],Integer.MAX_VALUE);

        q.offer(new int[]{x1,y1});
        dist[x1][y1] = 0;
        int step = 0;
        while(q.size() > 0){
            int len = q.size();
            while(len -- > 0){
                int[] temp = q.poll();
                int a = temp[0];
                int b = temp[1];

                for(int i=0;i<4;++i){
                    for(int j=1;j<=k;++j){
                        int na = a+j*pos[i][0];
                        int nb = b+j*pos[i][1];

                        if(na < 0 || na >= n || nb < 0 || nb >= m || g[na][nb] == '#') break;

                        //重点优化语句 不加会TLE 加了就过了
                        //如果(na,nb)这个点距离起点的距离已经小于从(a,b)这个点更新过来的距离，那就不需要再使用(a,b)这个点来更新后续节点，后续节点之后会使用(na,nb)这个点更新，相等于进行了剪枝
                        //证明
                        //dist[na][nb] < dist[a][b] + 1
                        //则dist[na][nb] + 1 <= dist[a][b] + 1
                        //所以使用dist[na][nb]更新后续节点一定不会差于使用dist[a][b]更新后续节点
                        if(dist[na][nb] < dist[a][b] + 1) break;

                        if(dist[na][nb] > dist[a][b] + 1){
                            dist[na][nb] = dist[a][b] + 1;
                            if(na == x2 && nb == y2){
                                System.out.println(dist[na][nb]);
                                return;
                            }
                            q.offer(new int[]{na,nb});
                        }
                    }
                }
            }
        }
        System.out.println(-1);

    }
    
    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        // while (t-- > 0) {
            m.solve();
        // }
    }
    //对一个数组求和
    long sumArr(int[] arr){
        long res = 0L;
        for(int i=0;i<arr.length;++i){
            res += (long)arr[i];
        }
        return res;
    }
    //棋盘距离
    int chessDis(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    //欧氏距离
    double ouDis(double x1,double y1,double x2,double y2){
        return Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));
    }    
    //读入一个整型数组
    int[] scIntArr(int n){
        int[] a = new int[n];
        for(int i=0;i<n;++i) a[i] = sc.nextInt();
        return a;
    }
    //读入一个long类型数组
    long[] scLongArr(int n){
        long[] a = new long[n];
        for(int i=0;i<n;++i) a[i] = sc.nextLong();
        return a;
    }
    //读入一个String类型的数组
    String[] scStringArr(int n){
        String[] a = new String[n];
        for(int i=0;i<n;++i) a[i] = sc.next();
        return a;
    }
    long gcd(long a, long b) {long t;while(b!=0) {t=b;b=a%b;a=t;}return a;}
    long lcm(long a,long b){return (a*b)/gcd(a,b);}
    long lowbit(long x){ return (x & (-x));}
    //快速幂不取mod
    long fastExp(long a,long b){
        long ans = 1;
        while(b != 0){
            if((b & 1) == 1) ans = ans * a;
            a = a * a;
            b >>= 1;
        }
        return ans;
    }   
    //快速幂取mod
    long fastExp(long a,long b,long p){
        long ans = 1L;
        while(b != 0){
            if((b & 1) == 1) ans = ans * a % p;
            a = a * a % p;
            b >>= 1;
        }
        return ans;
    }    
    
    private static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // 标准 IO
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // 文件 IO
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }
        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
```