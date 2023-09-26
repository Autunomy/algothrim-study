算法标签: 贪心、数学、字符串、构造、1400

题意:
给一个字符串，长度为1~|s| (|s|是字符串的长度)，给出m次操作，每次操作给出一个ai,每次操作需要将从ai开始到|s|-ai+1的字符串进行反转(下标从1开始),求操作完成后的字符串

思路:
如果存在两个同样的ai，直接抵消，就不进行操作，将所有剩余的操作放入一个集合list中并按照下标从小到大排序，每两个下标i,j为一组，交换a[i]与a[j] ,a[i+1]与a[j-1]直到 i >= j结束
如果list集合是奇数，则将最后一个元素特殊处理，处理的方式就是从endi~|s|-endi+1位置的所有元素进行反转


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
        char[] ch = sc.next().toCharArray();
        int m = sc.nextInt();

        //a[i]表示i操作的数量
        int[] a = new int[100010];

        //统计所有的操作
        for(int i=0;i<m;++i){
            int x = sc.nextInt();
            //之前出现过当前操作，直接抵消
            if(a[x] == 1) a[x] = 0;
            else a[x] = 1;
        }

        List<Integer> list = new ArrayList<>();

        //将所有操作升序放入list中
        for(int i=1;i<100010;++i){
            if(a[i] == 1){
                list.add(i-1);
            }
        }

        //两两一组反转
        for(int i=0;i + 1<list.size();i+=2){
            for(int j=list.get(i);j<list.get(i+1);++j){
                char temp = ch[j];
                ch[j] = ch[ch.length - j-1];
                ch[ch.length-j-1] = temp;
            }
        }

        //为奇数则最后一个下标特殊处理
        if(list.size() % 2 == 1){
            for(int i=list.get(list.size()-1);i<ch.length / 2;++i){
                char temp = ch[i];
                ch[i] = ch[ch.length - i-1];
                ch[ch.length-i-1] = temp;
            }    
        }
        

        String s = new String(ch);
        System.out.println(s);

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