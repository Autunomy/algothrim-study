思路：二分答案，主要的问题就在于check方法的编写。返回值不应该是一个boolean值，而是一个具体的值，表示当前值是第几小的值
如果在O(n)时间复杂度中得到当前mid是第几小？
注意到我们对a和b数组都进行了排序,那么就可以利用两个指针去判断。设置一个变量cnt，表示当前有多少个数比mid小，一个指针q初始情况指向的是b的最后一位，一个指针i初始指向第一个a
如果当前`a[i] * b[q] > mid` 则 q--
如果当前`a[i] * b[q] <= mid` 则 cnt += q+1  i++;
但是这个题目还没有完，题目还说了食材vi不能用第ui​种烹饪方式进行烹饪,所以需要再开一个list用来记录`a[u] * b[v]`的值，然后在上面的过程完成之后，再遍历list,将所有小于等于mid的数从cnt中减去最后的cnt就是返回值

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
    int n,m,k,q;
    int[] a,b;
    List<Long> list;
    long[][] mul;

    long check(long mid){
        long cnt = 0L;
        int q = m-1;
        for(int i=0;i<n && q >= 0;++i){
            while(q >= 0 && (long)a[i] * b[q] > mid) q--;
            cnt += ((long)q + 1);
        }

        for(long i : list) {
            if(i <= mid) cnt--;
        }
        return cnt;
    }

    void solve(){
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        q = sc.nextInt();
        a = scIntArr(n);
        b = scIntArr(m);
        
        list = new ArrayList<>();
        for(int i=0;i<k;++i){
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.add((long)a[u-1] * b[v-1]);
        }
        Arrays.sort(a);
        Arrays.sort(b);

        Collections.sort(list);
        while(q -- > 0){
            long x = sc.nextLong();
            // System.out.println(x);
            long left = 0L,right = 10000000000000L;
            while(left + 1 < right){
                long mid = (left + right) / 2;
                // long temp = ;
                if(check(mid) < x){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            System.out.println(right);
        }
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