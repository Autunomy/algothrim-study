思路: 将差值最大的两组数，分别放置在[0,0],[1,0],[0,1]
差值最大的两组数可以为：
1. 最大值、最小值、第二小值。最大值放在[0,0]处，如果行大于列最小值放在[1,0]，反之放在[0,1]
2. 最小值、最大值、第二大值。最小值放在[0,0]处，如果行大于列最大值放在[1,0]，反之放在[0,1]

[看图](https://www.processon.com/view/link/64590923c6c6ae7da698da49)

**被hack掉的原因**
```
1
2 2
1 3 3 3
```
上面这组数据答案应该是6，但是我输出的是4。问题在于只判断了最大值在左上角的问题，没有判断最小值在左上角的问题,直接将if判断小于0去掉即可

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
    int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = scIntArr(n*m);
        Arrays.sort(arr);
        int res1,res2=-1;
        res1 = (Math.max(n,m)-1)*(Math.min(n,m))*(arr[n*m-1]-arr[0])
                +(Math.min(n,m)-1) * (arr[n*m-1]-arr[1]);
        //错误代码
        // if(arr[0] < 0){
        //     res2 = (Math.max(n,m)-1)*(Math.min(n,m))*(arr[n*m-1]-arr[0])
        //         +(Math.min(n,m)-1) * (arr[n*m-2]-arr[0]);
        // }

        //正确代码 去掉if
        res2 = (Math.max(n,m)-1)*(Math.min(n,m))*(arr[n*m-1]-arr[0])
            +(Math.min(n,m)-1) * (arr[n*m-2]-arr[0]);
        int res = Math.max(res1,res2);
        System.out.println(res);
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        while (t-- > 0) {
            m.solve();
        }
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