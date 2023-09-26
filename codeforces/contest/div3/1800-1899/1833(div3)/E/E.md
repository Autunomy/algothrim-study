题意：
给定一个无向有环图，可以进行一个操作

- 如果一个连通块不是一个环，则它可以与另一个不为环的连通块连接成为一个

求两个值，连通块数量的最大值和最小值

思路：
求max的时候从每个点开始BFS，每BFS一次就将max++
求min的时候，判断如果是环就给min++，不是环不加一，最后判断是否有不成环的连通块，如果有再给min+1，没有就不+1


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

    int max = 0,min = 0;
    boolean[] st;

    void solve(){

        max = 0;
        min = 0;
        st = null;

        int n = sc.nextInt();
        int[] arr = scIntArr(n);

        Map<Integer,Set<Integer>> map = new HashMap<>();

        for(int i=0;i<n;++i){
            if(map.get(i+1) == null) map.put(i+1,new HashSet<>());
            if(map.get(arr[i]) == null) map.put(arr[i],new HashSet<>());

            map.get(i+1).add(arr[i]);
            map.get(arr[i]).add(i+1);
        }
        st = new boolean[n+1];
        for(int i=1;i<=n;++i){
            if(st[i]) continue;
            st[i] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while(q.size() > 0){
                int len = q.size();
                while(len -- > 0){
                    int x = q.poll();
                    for(int val : map.get(x)){
                        if(!st[val]){
                            q.offer(val);
                            st[val] = true;
                        }
                    }
                }
            }
            max ++;
        }

        boolean flag = false;
        st = new boolean[n+1];
        for(int i=1;i<=n;++i){
            if(st[i]) continue;
            if(map.get(i).size() == 2){
                st[i] = true;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                boolean temp = true;
                while(q.size() > 0){
                    int len = q.size();
                    while(len -- > 0){
                        int x = q.poll();
                        for(int val : map.get(x)){
                            if(st[val]) continue;
                            st[val] = true;
                            if(map.get(val).size() == 2){
                                q.offer(val);
                            }else{
                                temp = false;
                            }
                        }
                    }
                }
                if(temp)
                    min ++;
                else flag = true;
            }else{
                // for(int val : map.get(i)){
                //     if(map.get(val).size() == 1) flag = true;
                // }
                flag = true;
                // st[i] = true;
            }
        }
    
        if(flag) min ++;

        System.out.println(min + " " + max);

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