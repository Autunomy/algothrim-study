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
        int n = sc.nextInt();
        String t = sc.next();

        
    }

    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        int t = 1;
        while (t-- > 0) {
            m.solve();
        }
    }

    //二分找小于等于v的数，这个是开区间写法，注意l和r传入的应该是一个闭区间
    int lowerBound(int[] a,int l,int r,int v){
        int left = l - 1,right = r + 1;
        while(left + 1 < right){
            int mid = (left + right) >>> 1;
            if(a[mid] >= v) right = mid;
            else left = mid;
        }
        return left;
    }

    int lowerBound(long[] a,int l,int r,long v){
        int left = l - 1,right = r + 1;
        while(left + 1 < right){
            int mid = (left + right) >>> 1;
            if(a[mid] >= v) right = mid;
            else left = mid;
        }
        return left;
    }   

    void swap(char[] arr,int i,int j){char c = arr[i];arr[i] = arr[j];arr[j] = c;}
    void swap(int[] arr,int i,int j){int a = arr[i];arr[i] = arr[j];arr[j] = a;}
    //棋盘距离
    int chessDis(int x1,int y1,int x2,int y2){return Math.abs(x1-x2) + Math.abs(y1-y2);}
    //欧氏距离
    double ouDis(double x1,double y1,double x2,double y2){return Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));}
    //读入一个整型数组
    int[] scIntArr(int n){int[] a = new int[n];for(int i=0;i<n;++i) a[i] = sc.nextInt();return a;}
    //读入一个long类型数组
    long[] scLongArr(int n){long[] a = new long[n];for(int i=0;i<n;++i) a[i] = sc.nextLong();return a;}
    //读入一个String类型的数组
    String[] scStringArr(int n){String[] a = new String[n];for(int i=0;i<n;++i) a[i] = sc.next();return a;}
    //公约数
    long gcd(long a, long b) {long t;while(b!=0) {t=b;b=a%b;a=t;}return a;}
    //公倍数
    long lcm(long a,long b){return (a*b)/gcd(a,b);}
    //求二进制最低位
    long lowbit(long x){ return (x & (-x));}
    //快速幂不取mod
    long fastExp(long a,long b){long ans = 1;while(b != 0){if((b & 1) == 1) ans = ans * a;a = a * a;b >>= 1;}return ans;}
    //快速幂取mod
    long fastExp(long a,long b,long p){long ans = 1L;while(b != 0){if((b & 1) == 1) ans = ans * a % p;a = a * a % p;b >>= 1;}return ans;}
    //求组合数
    long combination(long n, long k) {long a=1,b=1;if(k>n/2) k=n-k;for(long i=1;i<=k;i++) {a*=(n+1-i);b*=i;}return a/b;}
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