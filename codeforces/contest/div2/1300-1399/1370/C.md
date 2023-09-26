算法标签: 游戏、数学、数论、1400

题意:
给定一个n，可以进行如下操作：
1. 给如果n大于1 给n减一
2. 如果n有奇数除数x，那么n可以等于n/x

两个玩家Ashishgup和FastestFinger进行游戏，谁当前操作1，谁输。Ashishgup先操作

思路:
分类讨论
1. n == 1 Ashishgup输
2. n > 1 && n为奇数 Ashishgup每次都可以除以n本身使其变成1，让FastestFinger一定输
3. n > 1 && n为偶数 
    1. 如果n是2的幂，此时是没有奇数除数，那么Ashishgup只能将其减一变为n-1，然后FastestFinger再除以n-1变为1 Ashishgup输
    2. 如果n不是2的幂，那么此时有奇数除数，那么Ashishgup可以将其除以奇数除数使其变为2的幂，然后FastestFinger只能执行减一操作，如果此时n等于1,那么Ashishgup,如果n>1,那么Ashishgup再除以这个数自身，此时就变为1，那么FastestFinger必输

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
        
        if(n == 1){
            System.out.println("FastestFinger");
            return;
        }else if(n == 2){
            System.out.println("Ashishgup");
            return;
        }else if(n % 2 == 1){//奇数的情况
            System.out.println("Ashishgup");
            return;
        }
        
        //n不是2的幂
        if((n / 2) % 2 == 1){
            //判断n/2是不是质数 
            //如果除2是质数，则一定是一个奇数，FastestFinger可以除以它自身将其变为1，FastestFinger获胜
            if(isPrime(n / 2)){
                System.out.println("FastestFinger");
            }else{//如果除2不是质数，则一定有偶数除数，此时无论FastestFinger怎么做都会输。
                System.out.println("Ashishgup");
            }
            return;
        }
        
        //n是2的幂
        if((n&(n-1)) == 0){
            System.out.println("FastestFinger");
            return;
        }else{
            System.out.println("Ashishgup");
            return;
        }
        

    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        while (t-- > 0) {
            m.solve();
        }
    }
    
    //判断一个数是不是质数
    boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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