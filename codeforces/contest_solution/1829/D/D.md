# D

题意：

可以进行的操作：将n分为两堆，其中一堆是另一堆的一倍

判断是否可以在若干次操作内分出来m

思路：

模拟以下分的过程，但是要注意使用set去重，防止超时

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
        int m = sc.nextInt();
        
        if(n == m) {
            System.out.println("YES");
            return;
        }
        if(n < m || n < 3 || n % 3 != 0) {
            System.out.println("NO");
            return;
        }
        Set<Integer> s = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        
        q.addLast(n);
        while(q.size() > 0){
            int len = q.size();
            while(len -- > 0){
                int x = q.poll();
                if(!s.contains(x)){
                    s.add(x);
                    if(x == m){
                        System.out.println("YES");
                        return;
                    }
                    
                    if(x % 3 == 0){
                        if(x / 3 >= m){
                            q.addLast(x/3);
                        }
                        if(2*x/3 >= m){
                            q.addLast(2*x/3);
                        }
                    }
                }
            }
        }
        System.out.println("NO");
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
