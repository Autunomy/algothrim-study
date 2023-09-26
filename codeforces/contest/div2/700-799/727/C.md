算法标签: 交互、构造题、数学、1400

题意:
这是一个交互式问题。您应该在每行打印后使用刷新操作。例如，在C++中你应该使用fflush（stdout），在Java中你应该使用System.out.flush（），在Pascal中你应该使用flush（output）。
在这个问题中，你应该猜测一个数组a，这对你来说是未知的。您最初拥有的唯一信息是数组 a 的长度 n。
可以询问n次，每次询问两个下标对应的数组元素之和，例如询问i,j则返回ai+aj
询问的格式是`? i j`
n此询问之后需要得到这个数组，输出的格式是`! a1 a2 ... an`
ai一定是正整数

思路:
先询问(1,2),(1,3),(2,3)利用a1 + a2 + a1 + a3 - a2 - a3可以计算出a1的值，然后利用a1的值算出a2,a3，此时询问了3次，之后的每次询问只需要询问(1,i)，就可以利用a1计算出所有


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
        int[] arr = new int[n];

        System.out.println("? " + 1 + " " + 2);
        System.out.flush();
        arr[0] = sc.nextInt();

        System.out.println("? " + 1 + " " + 3);
        System.out.flush();
        arr[1] = sc.nextInt();

        System.out.println("? " + 2 + " " + 3);
        System.out.flush();
        arr[2] = sc.nextInt();

        for(int i=4;i<=n;++i){
            System.out.println("? " + 1 + " " + i);
            System.out.flush();
            arr[i-1] = sc.nextInt();
        }
        int[] res = new int[n];
        res[0] = (arr[0] + arr[1] - arr[2])/2;
        res[1] = arr[0] - res[0];
        res[2] = arr[1] - res[0];
        for(int i=4;i<=n;++i){
            res[i-1] = arr[i-1] - res[0];
        }

        System.out.print("! ");
        for(int i=0;i<n;++i) System.out.print(res[i] + " ");
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