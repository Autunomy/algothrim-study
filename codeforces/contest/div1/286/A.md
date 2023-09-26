算法标签: 数学、构造题、1400

题意:
构造一个1~n的排列p使得`p[p[i]] = n-i+1`
例如 n = 4，排列为`2 4 1 3 ` 
```
p[p[1]] = p[2] = 4 - 1 + 1 = 4
p[p[2]] = p[4] = 4 - 2 + 1 = 3
p[p[3]] = p[1] = 4 - 3 + 1 = 2
p[p[4]] = p[3] = 4 - 4 + 1 = 1
```
如果无法构造输出-1

思路:
如果n%4 > 1 则无法形成一个合理的排列
通过手动模拟发现排列总是4个一组，前两个和后两个总是会对应上，那么就按照规律填数字即可


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
        if(n % 4 > 1) {
            System.out.println(-1);
        }else{
            int[] res = new int[n+1];
            
            //leftidx就是左边的下标 rightidx就是右边的下标
            int leftidx = 1,rightidx = n;
            //cntl小的数字  cntr表示大的数字
            int cntl = 1,cntr = n;
            while(leftidx < rightidx){
                res[rightidx-1] = cntl++;
                res[leftidx] = cntl ++;
                res[leftidx+1] = cntr--;
                res[rightidx] = cntr--;
                leftidx +=2;
                rightidx -= 2;
            }
            
            if(n % 4 == 1){
                res[n/2 + 1] = n/2 + 1;
            }
            for(int i=1;i<=n;++i){
                System.out.print(res[i] + " ");
            }
        }
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
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