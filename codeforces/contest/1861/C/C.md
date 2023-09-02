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
    void solve(){
        String s = sc.next();
        int n = s.length();

        int cnt = 0;//当前list中包含的元素数量
        int l = 2;//最短不是非递减前缀的结尾下标
        int r = 0;//最长非递减前缀的结尾下标

        for(int i=0;i<n;++i){
            char c = s.charAt(i);
            if(c == '+'){
                if(r == cnt) r++;//当前最长的有序序列就是整个list，那么就让r也++
                cnt++;
            }else if(c == '-'){
                cnt --;
                r = Math.min(r,cnt);//更新最长前缀
                if(cnt < l){
                    l = Math.max(2,cnt + 1);//因为最少2个元素才能构成一个递减的
                }
            }else if(c == '1'){
                if(r < cnt){//整个序列并不是非递减的 就直接输出NO
                    System.out.println("NO");
                    return;
                }
                //整个序列都是非递减的 所以需要更新l  
                l = Math.max(2,cnt + 1);
            }else{
                //序列长度小于l 表示当前序列是非递减的
                if(l > cnt){
                    System.out.println("NO");
                    return;
                }

                //当前序列不是非递减的
                r = Math.min(r,cnt - 1);
            }
        }
        System.out.println("YES");
    }   
    
    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        // int t = 1;
        while (t-- > 0) {
            m.solve();
        }
    }
    void swap(char[] arr,int i,int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    void swap(int[] arr,int i,int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
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