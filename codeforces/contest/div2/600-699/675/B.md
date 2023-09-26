算法标签: 构造题、暴力、数学、1400

题意:

瓦夏在画廊担任守望者。不幸的是，最昂贵的一幅画在他值班时被盗。他不想被解雇，所以他必须迅速恢复这幅画。他记得一些关于它的事实。

- 这幅画是一个正方形 3 × 3，每个单元格包含一个从 1 到 n 的整数，不同的单元格可能包含不同或相等的整数。
- 四个子正方形大小为2 × 2 中每个方格的整数之和等于左上角子正方形 2 × 2 中的整数之和。
- 四个元素a，b，c和d是已知的，其位置是(0,1),(1,0),(1,2),(1,1) 下标从0开始

帮助瓦夏找出满足上述所有条件的不同方案数。答案可能为0
注意：两个方案之间至少有两个数字不同才算两个方案不同

思路:

由于最中间的格子无论放哪个数字都不会影响四个子正方形的大小关系，所以最中间的方格可以取值的方案数为n
接下来只需要判断四个角即可。求出四个子正方形中的最大值和最小值，左上角的方格的值x必须让左上角的子正方形先等于其中的最大值，则左上角方格可取的方案数为n-x,最后用n * (n - x)得到答案
注意：x如果 <= 0则输出0，表示没有方案数


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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        long res = 0;
        int l1 = a + b;
        int r1 = a + c;
        int l2 = b + d;
        int r2 = c + d;

        int max = Math.max(l1,r1);
        int min = Math.min(l1,r1);
        max = Math.max(max,l2);
        max = Math.max(max,r2);
        min = Math.min(min,l2);
        min = Math.min(min,r2);

        int x = n - (max - min);

        if(x <= 0){
            System.out.println(0);
            return;
        }

        res += (long)x * n;
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        int t = 1;
        while (t-- > 0) {
            m.solve();
        }
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