算法标签:暴力、构造、1400

题意:
给出n个6位数代码，判断最多可以写错多少位仍然能够分辨每一个代码


思路:
统计每对代码不同的字符数量cnt，可以写错的字符数量小于等于(cnt-1)/2
例如下面这对代码
```
112345
115432
不同的字符数量为4
假设写错了4位，那可能存在一种情况是111111也就是后面四位全部写错了，此时无法判断是哪个代码
假设写错了3位，那可能存在一种情况是112432只有第3位(从1开始)，此时仍然无法分辨，错误的位有可能是4,5,6位,对应的是112345,错误的位可能是3,4,5,对应的是115432
假设写错了2位，那可能存在一种情况是112332,此时仍然无法分辨,错误的位有可能是5,6位,对应的是112345,错误的位可能是3,4,对应的是115432
假设写错了1为，那么一定可以进行分辨
```


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
        String[] arr = scStringArr(n);
        int res = 6;
        // 每2个字符串比较，看有点多少个地方不同
        // 最多只能写错 不同的字符串一半的(向下取整)的数量
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                int cnt = 0;
                for(int k=0;k<6;++k){
                    if(arr[i].charAt(k) != arr[j].charAt(k)) cnt++;
                }
                res = Math.min(res,(cnt - 1)/2);
            }
        }
        
        System.out.println(res);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
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