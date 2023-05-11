算法标签: 暴力、构造、1400

题意:
给定一个强度数组p，一个选择字符串s，选择字符串只包含A,B两个字符。可以进行一个操作：将任意长度的前缀或者后缀进行反转，A->B,B->A，只能进行一次
求可以B可以获取的最大强度(强度等于对应的p数组的元素和)

思路:
从前向后枚举，获取修改前缀可以获得的最大强度
从后向前枚举，获取修改后缀可以获得的最大强度
取两个之间的最大值

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
        int[] p = scIntArr(n);
        char[] arr = sc.next().toCharArray();
        long left = 0L;
        long right = 0L;
        for(int i=0;i<n;++i){
            if(arr[i] == 'B') right += (long)p[i];
        }
        //改前缀
        long temp = left + right;
        for(int i=0;i<n;++i){
            if(arr[i] == 'A'){
                left += (long)p[i];
            }else{
                right -= (long)p[i];
            }
            temp = Math.max(temp,left + right);
        }
        long res = temp;
        //改后缀
        left = 0L;
        right = 0L;
        for(int i=0;i<n;++i){
            if(arr[i] == 'B') left += (long)p[i];
        }
        temp = left + right;
        for(int i=n-1;i>=0;--i){
            if(arr[i] == 'A'){
                right += (long)p[i];
            }else{
                left -= (long)p[i];
            }
            temp = Math.max(temp,left + right);
        }
        res = Math.max(res,temp);
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