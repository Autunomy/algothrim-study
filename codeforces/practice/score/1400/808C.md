算法标签: 贪心、构造题、排序、1400

题意:
波利卡普邀请他所有的朋友参加茶话会庆祝节日。他有n个杯子，他的n个朋友每人一个,每个杯子的体积是ai毫升，他有一个茶壶存储w毫升的茶，
Polycarp希望以这样的方式将茶倒入杯中：
- 每杯至少含有一半体积的茶
- 每杯将包含整数毫升的茶
- 茶壶里所有的茶都会倒进杯子里
- 所有的朋友都会满意。

如果ai个杯子里面的茶水体积小于aj且ai杯子的体积大于aj，则朋友不满意
如果没有办法满足所有条件，输出-1
题目保证w <= a1+a2+...+an

思路:
排序一下(双关键字排序，体积和下标同时排序)，从小到大的体积先全部都倒一半，如果w为负数，输出-1。如果w还有剩余，从体积最大的杯子开始填满当前杯子，然后继续向前移动，填满第二大的杯子，以此类推
最后按照给定的杯子顺序输出一下包含的茶水数量

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
        int w = sc.nextInt();
        
        int[] a = scIntArr(n);
        int[][] nums = new int[n][2];
        for(int i=0;i<n;++i) {
            nums[i][0] = a[i];
            nums[i][1] = i;
        }
        Arrays.sort(nums,(o1,o2) -> o1[0] - o2[0]);

        int[] res = new int[n];
        for(int i=0;i<n;++i){
            res[i] = (nums[i][0] + 1) / 2;

            w -= (nums[i][0] + 1) / 2;
        }
        if(w < 0){
            System.out.println(-1);
            return;
        }

        int idx = n-1;
        while(w > 0 && idx >= 0){
            int temp = Math.min(nums[idx][0] - res[idx],w);
            res[idx] += temp;
            w -= temp;
            idx--;
            
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i == nums[j][1]){
                    System.out.print(res[j] + " ");
                    break;
                }
            }
        }
        System.out.println();
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