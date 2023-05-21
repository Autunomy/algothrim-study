题意：
给定n个数组，长度不同，最大值超过m，可以进行如下的操作
- 如果两个组中包含至少一个相同元素，则可以合并两个组

判断是否能让1和m都在同一组，如果可以输出最少操作次数，如果不可以输出-1

思路：
求最少次数一般都是BFS，这里BFS的是整个组，每次给q中增加元素时，遍历当前遍历的所有组中元素，将每个元素所在的其他组都加入到q中。结束条件是当前组中包含了1(因为初始化会将所有的m所在的集合放入q中)

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
        int m = sc.nextInt();

        //key是分组的编号 value是这一组内的值
        Map<Integer,Set<Integer>> arr = new HashMap<>();
        //key是元素，value是元素所在的组
        Map<Integer,List<Integer>> map = new HashMap<>();

        //q中存的是组的编号
        Queue<Integer> q = new ArrayDeque<>();
        //判断组是否被遍历过了
        boolean[] st = new boolean[n];

        for(int i=0;i<n;++i){
            int a = sc.nextInt();
            arr.put(i,new HashSet<>());
            for(int j=0;j<a;++j){
                int val = sc.nextInt();
                arr.get(i).add(val);
                if(map.get(val) == null) map.put(val,new ArrayList<>());
                map.get(val).add(i);
                //BFS从m所在的组开始
                if(val == m){
                    q.offer(i);
                }
            }
        }

        int step = 0;

        while(q.size() != 0){
            int len = q.size();
            while(len -- > 0){
                int x = q.poll();
                if(!st[x]){
                    st[x] = true;
                    //如果当前组包含1直接输出步数然后返回
                    if(arr.get(x).contains(1)){
                        System.out.println(step);
                        return;
                    }

                    //遍历组中的元素
                    for(int i : arr.get(x)){
                        //遍历元素所在的分组
                        for(int j : map.get(i)){
                            if(!st[j]){
                                q.offer(j);
                            }
                        }
                    }

                }

            }

            step ++;
        }
        System.out.println(-1);
    }


    
    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        int t = 1;
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