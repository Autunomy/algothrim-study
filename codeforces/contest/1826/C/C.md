
# C-[java]gcd+思维题+预处理

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

    public static void main(String[] args) {
        int N = 1000010;
        //预处理 将所有值的最小质因子求出来
        /*
            方法就是从2开始向后遍历，每次都将当前质数的所有倍数都标记为当前质数即可
        */
        int[] spf = new int[N];
        Arrays.fill(spf,Integer.MAX_VALUE);
        for(int i=2;i<N;++i){
            if(spf[i] == Integer.MAX_VALUE){
                for(int j=i;j<N;j+=i){
                    spf[j] = Math.min(i,spf[j]);
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            if(n == 1 || m == 1) {
                System.out.println("YES");
                continue;
            }
            
            if(n <= m){
                System.out.println("NO");
                continue;
            }
            //如果一个数的最小质因子spf[n]小于或等于m就代表n可以平均分配到spf[n]上，可以无限投票（会丢弃一些选项）
            //反之，spf[n] > m  第一次肯定会剩下 n % m个选项，之后发现spf[n]仍然大于n%m 所以可以继续投票并剔除一些选项，不断重复，直到最后只剩下一种选项
            System.out.println(spf[n] <= m ? "NO":"YES");
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