题意：
Vlad 被赋予了一个 n个正整数的数组 a。现在他想从中构建一个长度为 n的漂亮数组 b。
如果数组中的所有数字都是正数并且具有相同的奇偶校验，则 Vlad 认为数组很漂亮。也就是说，美丽数组中的所有数字都大于零，并且要么都是偶数，要么都是奇数。
要构建数组 b，Vlad 可以为每个 bi分配值 ai或 ai−aj，其中可以选择从 1到 n的任何 j
为了避免尝试做不可能的事情，Vlad 要求您确定是否可以使用他的数组 a构建一个长度为 n的漂亮数组 b

思路：
找到最小值min,如果min是奇数，则可以让整个数组都是奇数，因为偶数-奇数都是奇数
如果min是偶数，则判断如果数组中存在奇数，输出no，反之输出yes,因为最小是偶数，则必须全为偶数，奇数-偶数还是奇数

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
        int[] arr = scIntArr(n);

        // Arrays.sort(arr);
        int min = arr[0];
        int odd = 0;
        for(int i=0;i<n;++i){
            min = Math.min(min,arr[i]);
            if(arr[i] % 2 == 1) odd ++;
        }

        if(min % 2 == 1){
            System.out.println("YES");
            return;
        }

        if(odd > 0) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }
    
    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        // int t = 1;
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