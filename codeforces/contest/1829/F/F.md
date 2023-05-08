# F

题意：一个中心节点称为一级节点，上面连接x个节点称为二级节点，每个二级节点连接y个三级节点。给出一个图，求对应的x和y

思路：

图的节点数很小，可以使用邻接矩阵保存。

这个图中节点的边的数量的种数一定<=3，那么就可以统计一下每个节点的边的数量并排序，设最大值为a，大于1的最小值为b

三级节点的数量 = 所有边数为1的点的数量

由于x*y == 三级节点的数量，所以判断一下

- (a-1) * b == 三级节点的数量  那么 x = b,y = a-1
- a * (b-1) == 三级节点的数量  那么 x = a,y = b-1

这样判断的理由就是二级节点的边数-1是y，所以如果出现了-1，则一定是y

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
        
        int[][] g = new int[n][n];
        Map<Integer,Integer> bian = new HashMap<>();
        for(int i=0;i<m;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a-1][b-1] = 1;
            g[b-1][a-1] = 1;
            bian.put(a-1,b-1);
            bian.put(b-1,a-1);
        }
        int[] arr = new int[n];
        int max1 = -1,max2 = -1;
        for(int i=0;i<n;++i){
            int cnt = 0;
            for(int j=0;j<n;++j){
                if(g[i][j] == 1){
                    cnt++;
                }
            }
            arr[i] = cnt;
        }
        int mul = 0;
        for(int i=0;i<n;++i){
            if(arr[i] == 1) mul ++;
        }
        Arrays.sort(arr);
        int a = 0,b = arr[n-1];
        for(int i=0;i<n;++i){
            if(arr[i] > 1) {
                a = arr[i];
                break;
            }
        }
        
        if((a-1) * b == mul){
            System.out.println(b + " " + (a-1));
        }else{
            System.out.println(a + " " + (b-1));
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
