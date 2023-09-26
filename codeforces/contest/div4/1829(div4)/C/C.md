# C

题意：能够成11这个二进制串的最小花费，输入中前一个值为花费，另一个是可以获取的二进制串

思路：找到10对应的最小花费min10，01的最小花费min01，11的最小花费min11，他们的初始值为int的最大值`Integer.MAX_VALUE`

最终会有以下四种情况

- `(min10 == Integer.MAX_VALUE || min01 == Integer.MAX_VALUE) && min11 == Integer.MAX_VALUE` 说明无法构成一个11
- `min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE` 那么答案只能是min11
- `min11 == Integer.MAX_VALUE` 那么答案只能是`min01 + min10`
- 取两个最小

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

    void solve(){
        int n = sc.nextInt();
        int min01 = Integer.MAX_VALUE,min10 = Integer.MAX_VALUE,min11 = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            int a = sc.nextInt();
            String s = sc.next();
            if(s.equals("10")) min10 = Math.min(a,min10);
            if(s.equals("01")) min01 = Math.min(a,min01);
            if(s.equals("11")) min11 = Math.min(a,min11);
        }
        if((min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE) && min11 == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }else if(min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE){
            System.out.println(min11);
        }else if(min11 == Integer.MAX_VALUE){
            System.out.println(min01 + min10);
        }else{
            System.out.println(Math.min(min01 + min10 , min11));    
        }
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