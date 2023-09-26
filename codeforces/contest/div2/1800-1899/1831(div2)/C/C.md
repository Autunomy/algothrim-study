题意：有n个节点的图，给出画出n-1条边的顺序，并有以下的操作方式
1. 画顶点1
2. 对于输入的每一条边，按照顺序：如果这条边连接着已经画好的顶点u和未画好的顶点v，他将画出未画好的顶点v和这条边。检查完每条边后，进入步骤2
3. 如果所有的顶点都画好了，就终止算法。否则，转到步骤1

操作次数就是步骤1执行的次数，求操作次数

思路：
根据所有的边建立图，在建图的时候，需要同时保存边的权重，也就是下标。dfs遍历所有的路径，在路径中如果子节点的下标权重比父节点大说明可以按照顺序画出这条边，反之就需要额外1次操作。求出逆序对的最大数量即可

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
    int[][] pos4 = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int[][] pos8 = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    Map<Integer,List<int[]>> map;
    void solve(){
        int n = sc.nextInt();
        //key是u value中的list存储一个数组数组包含两个元素arr[0]表示v,arr[1]表示权重，也就是其在输入中的下标
        map = new HashMap<>();

        for(int i=0;i<n;++i) map.put(i,new ArrayList<>());
        for(int i=0;i<n-1;++i){
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            map.get(u).add(new int[]{v,i});
            map.get(v).add(new int[]{u,i});
        }

        System.out.println(dfs(0,-1,new boolean[n]) + 1);
    }

    //now表示当前节点编号 we表示now节点的权重 返回值是逆序对的最大数量
    int dfs(int now,int we,boolean[] st){
        int res = 0;
        st[now] = true;
        for(int[] arr : map.get(now)){
            int ne = arr[0];
            int w = arr[1];

            if(ne == now) continue;

            if(!st[ne]){
                //如果当前节点顺序在父节点的前面就需要+1
                res = Math.max(res,dfs(ne,w,st) + (w > we?0:1));
            }
        }
        st[now] = false;
        return res;
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