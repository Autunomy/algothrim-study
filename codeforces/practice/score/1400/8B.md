算法标签: 图、构造题、1400

题意:
给定一个移动的字符串，包含U,R,D,L4个字符分别代表:上，右，下，左。可以以任意起点出发，判断起点到终点的路径是否是最短路，如果是输出OK，不是输出BUG
路径中可能会有障碍物

思路:
假设此次移动是从下面移动到当前位置，则判断
1. 当前位置之前是否已经走到过了，如果走到过，那么中间的所有路径都是没用的，不满足最短路
2. 当前位置的右边是否走过，如果走过，则可以直接从右边到当前点，不满足最短路
3. 当前位置的上边是否走过，如果走过，则可以直接从上边到当前点，不满足最短路
4. 当前位置的左边是否走过，如果走过，则可以直接从左边到当前点，不满足最短路

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
        String s = sc.next();
        if(s.length() == 1){
            System.out.println("OK");
            return;
        }

        int[] dec = new int[s.length()];
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) =='U'){
                dec[i] = 0;
            }else if(s.charAt(i) == 'R'){
                dec[i] = 1;
            }else if(s.charAt(i) == 'D'){
                dec[i] = 2;
            }else{
                dec[i] = 3;
            }
        }

        int x = 110,y = 110;
        Set<String> set = new HashSet<>();

        set.add("" + x + y);

        for(int i=0;i<dec.length;++i){
            x += pos[dec[i]][0];
            y += pos[dec[i]][1];
            if(set.contains("" + x + y)){
                System.out.println("BUG");
                return;
            }
            int from = 0;
            if(dec[i] == 0) from = 2;
            if(dec[i] == 1) from = 3;
            if(dec[i] == 2) from = 0;
            if(dec[i] == 3) from = 1;

            for(int j=0;j<4;++j){
                if(j != from && set.contains("" + (x + pos[j][0]) + (y + pos[j][1]))){
                    System.out.println("BUG");
                    return;
                }
            }
            set.add("" + x + y);
        }
        System.out.println("OK");
        
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

