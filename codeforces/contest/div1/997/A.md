算法标签: 暴力、贪心、数学、1500

题意:
输入 n(1≤n≤3e5) x(0≤x≤1e9) y(0≤y≤1e9) 和长为 n 的 01 字符串 s。
你可以执行任意次操作，每次选择其中一种操作执行。
1. 花费 x，reverse s 的一个子串，例如 1110 -> 0111。
2. 花费 y，flip s 的一个子串，例如 1110 -> 0001。

目标：使 s 中只有 1。
输出最少花费。

思路:
贪心的思路  先将所有连续0的子数组记录到list中，只需要记录子数组中0的个数即可
1. 如果全为1，直接返回0
2. 返回`Math.min(y*list.size(),x*(list.size()-1)+y);`

翻译第二种情况：
`y*list.size()` 就是利用题目中的第二种操作将所有的连续0的子数组反转
`x*(list.size()-1)+y` 就是将所有的0都通过反转子串的方式放在一起，然后一次性将全部的0反转为1


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
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        String s = sc.next();
        
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<n;++i){
            if(s.charAt(i) == '0') cnt++;
            else if(cnt > 0){
                list.add(cnt);
                cnt = 0;
            }
        }
        
        if(cnt > 0) list.add(cnt);
        
        if(list.size() == 0){
            System.out.println(0);
            return;
        }
        System.out.println(Math.min((long)y*list.size(),(long)x*(list.size()-1) + y));
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
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