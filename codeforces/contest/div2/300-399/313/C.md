算法标签: 贪心、构造题、排序、1400

题意:
给一个4^n长度的数组，将其填入2^n * 2^n的正方形矩阵中，要求获得最大美感
美感的定义：
1. 如果n == 0则美感为当前值
2. 如果n > 0 ，一个2^n * 2^n的矩阵可以分为4个2^(n-1) * 2^(n-1)的子矩阵,每一个子矩阵的美感为当前子矩阵的最大值 + 子矩阵的元素和


思路:
每次分组都将当前子矩阵中的最大的四个值平均分配到每个子矩阵中，不断的分就会得到美感最大的矩阵。题目中并没有要求输出矩阵是什么，所以不需要模拟分配的过程，只需要找出计算的规律即可
题目给的输入就是矩阵的所有元素，将其排序，并求前缀和数组pre。定义一个chu表示当前有多少个子矩阵，chu从n开始，每次给答案加上`pre[n] - pre[n-chu-1]`,表示的是当前需要加上的子矩阵的最大值的和

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
    
    void solve(){
        int n = sc.nextInt();
        int[] arr = scIntArr(n);

        Arrays.sort(arr);
        long[] pre = new long[n+1];
        for(int i=1;i<=n;++i) pre[i] = pre[i-1] + (long)arr[i-1];

        long res = 0L;
        int chu = n;
        while(chu >= 1){
            res = res + (long)pre[n] - pre[n - chu];
            chu /= 4;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        // while (t-- > 0) {
            m.solve();
        // }
    }
    //对一个数组求和
    long nArr(int[] arr){
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
