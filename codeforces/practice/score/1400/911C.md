算法标签: 构造题、暴力、1400

题意:

米什卡正在装饰圣诞树。他有三个花环，它们都将放在树上。之后，米什卡将打开这些花环。
当花环打开时，它会周期性地改变其状态——有时它被点亮，有时不亮。正式地，如果第 i 个花环在第 x 秒内打开，那么它仅在秒 x、x + ki、x + 2ki、x + 3ki 等期间点亮。

米什卡想打开花环，这样在打开花环后的每一秒，都会至少有一个点燃的花环。形式上，Mishka 想要选择三个整数 x1、x2 和 x3（不一定是不同的），这样他就会在第 x1 秒期间打开第一个花环，第二个花环——在第 x2 秒期间，第三个花环——分别在第 x3 秒期间，并且在从 max（x1、x2、x3） 开始的每一秒中，至少会点亮一个花环。

是否有可能这样做？

输入是k1,k2,k3

思路:

只有四种情况满足条件
1. 有一个k为1
2. 至少两个k为2
3. k全为3
4. k包含2 4 4

其余情况都是NO
原因可能是，如果k为偶数，则可以让x为奇数使得后续都在奇数秒可以点亮，有一个x为2保证了所有的偶数时刻被点亮


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
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int k3 = sc.nextInt();

        if(k1 == 1 || k2 == 1 || k3 == 1){
            System.out.println("YES");
            return;
        }

        int cnt = 0;
        if(k1 == 2) cnt ++;
        if(k2 == 2) cnt ++;
        if(k3 == 2) cnt ++;

        if(cnt >= 2) {
            System.out.println("YES");
            return;
        } 

        if(k1 == 3 && k2 == 3 && k3 == 3){
            System.out.println("YES");
            return;
        }
        int[] arr = new int[]{k1,k2,k3};
        Arrays.sort(arr);
        if(arr[0] == 2 && arr[1] == 4 && arr[2] == 4){
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
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