# C
题意:对于整数 [a1,a2,…,an]的数组，我们将值 |a1−a2|+|a2−a3|+⋯+|an−1−an|称为数组的对比度。请注意，大小为 1的数组的对比度等于 0
构建一个数组b满足以下条件
1. b不为空
2. b是a的子序列
3. b的对比度等于a

求b的最小可能长度

思路:
观察对比度的计算式子可以发现，如果a的子数组是非递减或非递增的，那就可以使用两个端点值来代替整个子数组，于是我们暴力遍历这个a，将所有能合并的式子全部合并后就是b数组的长度


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

    int n;
    int[] arr;
    long sum;

    void solve(){
        n = sc.nextInt();
        arr = scIntArr(n);
        int[] stack = new int[n + 1];
        int top = -1;
        int idx = 0;

        while(idx < n){
            if(idx == 0) {
                stack[++top] = arr[idx++];
                continue;
            }
            while(idx < n && arr[idx] == arr[idx-1]) idx++;
            if(idx < n && arr[idx] > arr[idx-1]){
                while(idx < n && arr[idx] >= arr[idx-1]){
                    idx++;
                }
                idx--;
                stack[++top] = arr[idx++];
            }else if(idx < n && arr[idx] < arr[idx-1]){
                while(idx < n && arr[idx] <= arr[idx-1]){
                    idx++;
                }
                idx--;
                stack[++top] = arr[idx++];
            }
        }
        System.out.println(top + 1);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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