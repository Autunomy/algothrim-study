算法标签: 二分、构造题、贪心、1400

题意:
一张大贴纸上有n个小贴纸，Piegirl 想要使用贴纸创建字符串 s。她可以购买任意多张贴纸，并可以指定贴纸中的所有字符(每个大贴纸都是一模一样的，字符的种类和每种字符数量都相同)
一旦她拿到贴纸，她会从纸上取出一些贴纸并（以任何顺序）排列它们以形成 s。确定她必须购买的最少张数，并提供一个字符串来描述她应该购买的一张贴纸。

思路:
二分一下张数，求最小的张数即可

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
        String str = sc.next();
        int len = str.length();
        int n = sc.nextInt();
        
        int[] cnt = new int[26];
        for(int i=0;i<len;++i){
            cnt[str.charAt(i)-'a'] ++;
        }
        
        int res = -1;
        //表示需要的张数
        int left = 1,right = len;
        while(left <= right){
            //只买mid张是否可以
            int mid = (left + right) / 2;
            //对n做一个备份
            int nbk = n;
            for(int i=0;i<26;++i){
                //减去当前字母在当前页占用的字母数量
                nbk -= (cnt[i] + mid - 1) / mid;
            }
            //当前张数可以组成字符串s
            if(nbk >= 0){
                right = mid - 1;
                res = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(res);
        
        if(res != -1){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<26;++i){
                //每一张中放多少个当前字母
                int x = (cnt[i] + res - 1) / res;
                for(int j=0;j<x;++j){
                    sb.append((char)('a'+i));
                }
            }
            
            //如果不够n个字符需要进行填充 使用任意字符填充即可
            for(int i=n-sb.length();i>=1;--i) sb.append("a");
            System.out.println(sb.toString());
        }
        
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