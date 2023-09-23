思路：
AAAB -> AABC -> ABCC -> BCCC
BAAA -> CBAA -> CCBA -> CCCB

通过这两个例子就可以看出来B会不断的吃掉A，并且吃的过程是不可逆的，也就是说如果B一开始向左边吃，那么就只能一直向左，不能向右。此时就会有以下几种情况
1. B在整个字符串的两边，那么所有的A都会被吃掉，所以答案就是A的数量
2. B不在两边，每个被B分割的A都会形成一个组，那么整个字符串中就会有很多A形成的组，我们只需要将其中最小的一组A的数量减去，就会得到答案，这里要注意，BB这种情况下，两个B中间就算没有A也需要算一个组，数量为0



```java
import java.io.*;
import java.util.*;

/**
 * @author hty
 * @email 1156388927@qq.com
 * @description
 */

public class Main {
    private static Kattio sc = new Kattio();
    int[][] pos4 = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int[][] pos8 = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    int MOD = (int)1e9+7;
    void solve(){
        char[] arr = sc.next().toCharArray();
        int n = arr.length;
        int cntA = 0;
        
        for(int i=0;i<n;++i){
            if(arr[i] == 'A') {
                cntA ++;
            }        
        }

        for(int i=0;i<n-1;++i){
            if(arr[i] == 'B' && arr[i + 1] == 'B'){
                System.out.println(cntA);
                return;
            }
        }
        int cntG = n;
        int temp = 0;
        int idx = 0;
        while(idx < n){
            if(arr[idx] == 'B'){
                cntG = Math.min(cntG,temp);
                temp = 0;
            }else{
                temp ++;
            }

            idx ++;
        }
        cntG = Math.min(cntG,temp);

        System.out.println(cntA - cntG);
    }

    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        // int t = 1;
        while (t-- > 0) {
            m.solve();
        }
    }
    void swap(char[] arr,int i,int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    void swap(int[] arr,int i,int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
    //防止Arrays.sort()超时
    void ruffleSort(int[] a) {
        Random random = new Random();
        int n = a.length;//打乱然后排序
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    void ruffleSort(long[] a) {
        Random random = new Random();
        int n = a.length;//打乱然后排序
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
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
    //求组合数
    long combination(long n, long k) {
        long a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(long i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return a/b;
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