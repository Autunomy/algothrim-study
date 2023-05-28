题意：
给定一个字符串s，包含a和A，给出三种操作
1. 直接按a键，代价是x
2. 按a+shift，代价是y
3. 按cap，代价是z

求形成s的最小代价，初始状态下cap是关闭状态

思路：
dp

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
    int[][] pos4 = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int[][] pos8 = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    void solve(){
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();

        String s = sc.next();
        int n = s.length();
        long[][] dp = new long[s.length()+1][2];
        //初始化为inf，为了方便取min
        for(int i=0;i<=n;++i) Arrays.fill(dp[i],400000000000000L);
        dp[0][0] = 0;

        for(int i=0;i<n;++i){
            //当前字母是a还是A
            int c = s.charAt(i) == 'a'?0:1;

            for(int j=0;j<2;++j){//上一个字母的cap键的打开状态
                for(int k=0;k<2;++k){//当前字母cap键的打开状态
                    long temp = dp[i][j];
                    if(j != k) temp += z;
                    if(c == k) temp += x;
                    else temp += y;

                    dp[i+1][k] = Math.min(temp,dp[i+1][k]);
                }
            }
        }
        System.out.println(Math.min(dp[n][0],dp[n][1]));
    }



    
    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        int t = 1;
        while (t-- > 0) {
            m.solve();
        }
    }
    //防止Arrays.sort()超时
    void ruffleSort(int[] a) {
        Random random = new Random();
        int n = a.length;//打乱然后排序
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    void ruffleSort(long[] a) {
        Random random = new Random();
        int n = a.length;//打乱然后排序
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
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