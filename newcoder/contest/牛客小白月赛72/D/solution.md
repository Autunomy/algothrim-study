思路:首先把不传送产生的dp数组求出来，这里我为了更加明显，使用`dp1[i][j]`表示从(0,0)到(i,j)可以获得的最大价值,用`dp2[i][j]`表示从(n-1,m-1)到(i,j)可以获得的最大价值
预处理完成之后，暴力遍历所有的传送门，并判断每个传送门到另一个传送门后的价值之和
设第一个传送门的横纵坐标为a,b，另一个传送门的坐标为c,d，则计算方法为:`dp1[a][b] + dp2[c][d]`

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

        int[][] arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j] = sc.nextInt();
            }
        }

        long[][] dp1 = new long[n][m];
        dp1[0][0] = arr[0][0];
        for(int i=1;i<m;++i){
            dp1[0][i] = (long)dp1[0][i-1] + arr[0][i];
        }
        for(int i=1;i<n;++i){
            dp1[i][0] = (long)dp1[i-1][0] + arr[i][0];
        }
        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                dp1[i][j] = Math.max((long)dp1[i-1][j],dp1[i][j-1]) + (long)arr[i][j];
            }
        }

 

        long[][] dp2 = new long[n][m];
        dp2[n-1][m-1] = arr[n-1][m-1];
        for(int i=m-2;i>=0;--i){
            dp2[n-1][i] = (long)dp2[n-1][i+1] + arr[n-1][i];
        }
        for(int i=n-2;i>=0;--i){
            dp2[i][m-1] = (long)dp2[i+1][m-1] + arr[i][m-1];
        }
        for(int i=n-2;i>=0;--i){
            for(int j=m-2;j>=0;--j){
                dp2[i][j] = Math.max((long)dp2[i+1][j],dp2[i][j+1]) + (long)arr[i][j];
            }
        }
        int t = sc.nextInt();
        while(t -- > 0){
            int k = sc.nextInt();
            long res = dp1[n-1][m-1];  
            int[][] tp = new int[k][2];
            for(int i=0;i<k;++i) {
                tp[i][0] = sc.nextInt() - 1;
                tp[i][1] = sc.nextInt() - 1;
            }
            for(int i=0;i<k;++i){
                int a = tp[i][0];
                int b = tp[i][1];
                for(int j=0;j<k;++j){
                    if(j == i) continue;
                    int c = tp[j][0];
                    int d = tp[j][1];

                    res = Math.max(res,(long)dp1[a][b] + dp2[c][d]);
                }
            }
            System.out.println(res);

        }

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