算法标签: 数学、构造题、1400

题意:
瓦莱拉喜欢参加比赛。特别是在编程竞赛中。今天，他和他的团队一起参加了比赛，由n名学生（包括Valera）组成。本次比赛是个人比赛，所以团队中的每个学生都单独解决问题。
比赛结束后，瓦莱拉对结果很感兴趣。他发现：
1. 团队中每个学生至少获得L分，最多R分;
2. 每个学生都获得一个整数分数
3. 得分最高的k个学生得分总和为sk

题目保证有解，按照任意顺序输出即可

思路:
先用前k个元素把sk平均分配，注意是平均分配，如果不能平均就将为分配的分数从第一个人开始向后分配，每次都分配到r分，直到分配完
然后从sall中减去sk，开始分配后n-k个学生，按照要求分配完成即可

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
        int k = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int sall = sc.nextInt();
        int sk = sc.nextInt();

        int[] res = new int[n];


        sall -= sk;
        int temp = sk / k;

        sk = sk % k;

        for(int i=0;i<k;++i){
            res[i] = temp;
        }

        for(int i=0;i<k && sk > 0;++i){
            int x = r - res[i];
            res[i] += Math.min(sk,x);
            sk -= Math.min(sk,x);
        }
        
        for(int i=k;i<n;++i){
            res[i] = l;
            sall -= l;
        }
        temp = res[k-1];


        for(int i=k;i<n && sall > 0;++i){
            res[i] += Math.min(sall,temp-l);
            sall -= Math.min(sall,temp-l);
        }
        for(int i=0;i<n;++i){
            System.out.print(res[i] + " ");
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