算法标签: DFS、图论、贪心、构造题、1400

题意:
给出一个二维数组，其中全部都是0和1，arr[i][j] == 1则代表ai是aj的一个真子集，也就是说ai!=aj
求出n个集合满足二维数组的条件

思路:
DFS暴力搜索即可


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
    Set<Integer>[] res;
    char[][] arr;
    boolean[] st;
    int cnt,n;
    void solve(){
        n = sc.nextInt();
        arr = new char[n][n];
        for(int i=0;i<n;++i){
            arr[i] = sc.next().toCharArray();
        }
        res = new Set[n+1];
        st = new boolean[n+1];
        for(int i=0;i<=n;++i){
            res[i] = new HashSet<>();
        }
        cnt = 0;
        //dfs所有的集合，这里的cnt是为了让i变为j的真子集而给j添加的新元素
        for(int i=0;i<n;++i){
            if(!st[i+1]){
                cnt++;
                dfs(i);
            }
        }

        //输出答案
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;++i){
            sb.append(res[i+1].size() + " ");
            for(int j : res[i+1]){
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    //dfs遍历所有的父集
    void dfs(int i){
        //添加一个元素，这个元素在子集中没有出现过，这样才能保证是真子集
        res[i+1].add(cnt);
        //将当前集合标记为true，表示已经进行过遍历
        st[i+1] = true;

        for(int j=0;j<n;++j){
            if(arr[i][j] == '1'){//如果j是i的父集
                res[j+1].addAll(res[i+1]);//将i全部添加到j中
                if(!st[j+1]){//判断如果j没有被遍历过，就继续dfs(j)
                    cnt++;
                    dfs(j);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        // int t = 1;
        while (t-- > 0) {
            m.solve();
        }
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