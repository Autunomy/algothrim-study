算法标签: 构造题、1400

题意:
给定正方形的边长为n，给定1的个数为k，将k个1填充到正方形中，正方形是按照对角线(左上到右下)对称的，求字典序最大的正方形

如果第一个矩阵顶部的第一个不同行中的第一个不同数字大于第二个矩阵中的相应数字，则一个矩阵在字典上大于另一个矩阵

思路:
从左到右，从上到下一次遍历整个矩阵，如果当前位置不为1
1. i == j 说明是对角线元素，给res[i][j]填入1，k--
2. i != j 如果k >= 2 则res[i][j] = 1;res[j][i] = 1; k<2 就不操作

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
        int[][] res = new int[n][n];
        if(k == 0){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        if(k > n * n){
            System.out.println(-1);
            return;
        }

        for(int i=0;i<n && k > 0;++i){
            for(int j=0;j<n && k > 0;++j){
                if(res[i][j] != 1){
                    if(i == j){
                        res[i][j] = 1;
                        k--;
                    }else{
                        if(k >= 2){
                            res[i][j] = 1;
                            res[j][i] = 1;
                            k-=2;
                        }
                    }
                }

            }
        }
        
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
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