# E

题意：类似于力扣的岛屿面积，所有不为0的地方为湖，求湖的面积最大的湖。面积是湖对应的所有格子的数字之和

思路：dfs或bfs搜一下即可

```java
import java.io.*;
import java.util.*;

/**
 * @author hty
 * @date 2023-04-28 18:24
 * @email 1156388927@qq.com
 * @description
 * @other 题解及更多请看www.autunomy.top
 */

public class Main {
    private static Kattio sc = new Kattio();
    boolean[][] st;
    int[][] arr;
    int n,m;
    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};
    void solve(){
         n = sc.nextInt();
         m = sc.nextInt();
        
        arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j] = sc.nextInt();
            }
        }
        
        st = new boolean[n][m];
        
        int res = 0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(!st[i][j]){
                    res = Math.max(res,dfs(i,j));
                }
            }
        }
        System.out.println(res);
    }
    
    int dfs(int x,int y){
        if(x < 0 || x >= n || y < 0 || y >= m || arr[x][y] == 0 || st[x][y]) return 0;
        int res = arr[x][y];
        st[x][y] = true;
        for(int i=0;i<4;++i){
            res += dfs(x+dx[i],y+dy[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        while (t-- > 0) {
            m.solve();
        }
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
