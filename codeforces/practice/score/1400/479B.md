算法标签: 暴力、贪心、排序、构造题、1400

题意:
如你所知，伯兰德的所有孩子都喜欢玩立方体。小彼佳有n座由相同大小的立方体组成的塔楼。带有数字 i 的塔由一个堆叠在另一个之上的 ai 立方体组成。Petya将一组塔的不稳定性定义为等于最高塔和最低塔高度之差的值。例如，如果Petya建造了五个高度为（8，3，2，6，3）的立方体塔，则该集合的不稳定性等于6（最高的塔的高度为8，最低的高度为2）。

男孩希望他的塔的不稳定性尽可能低。他所能做的就是多次执行以下操作：从某个塔中取出顶部立方体，然后将其放在他设置的其他塔的顶部。请注意，Petya永远不会将立方体放在移除立方体的同一塔上，因为他认为这是浪费时间。

在上学之前，男孩将有时间进行不超过k这样的操作。彼佳不想上课迟到，所以你必须帮他完成这个任务。

输入

第一行包含两个空格分隔的正整数 n 和 k（1 ≤ n ≤ 100，1 ≤ k ≤ 1000）——给定集合中的塔的数量和 Petya 可以执行的最大操作数。第二行包含 n 个空格分隔的正整数 ai（1 ≤ ai ≤ 104）——塔的初始高度。

输出

在第一行中打印两个空格分隔的非负整数和 m （m ≤ k）。第一个数字是执行最多 k 个操作后可以获得的最小可能不稳定性的值，第二个数字是为此所需的操作数。

在接下来的 m 行中，将每个操作的描述打印为两个正整数 i 和 j，每个都位于 1 到 n 的限制范围内。它们代表彼佳从第i塔中取出顶部立方体，并放入第j个立方体（i ≠ j）。请注意，在执行操作的过程中，某些塔的高度可能等于零。

如果有多个正确的序列可以达到最小的可能不稳定性，则可以打印其中任何一个。

思路:
将下标和高度同时排序，每次都将最高的塔的立方体放在最低的塔上，然后再次排序


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

        int[][] arr = new int[n][2];

        for(int i=0;i<n;++i){
            arr[i][0] = sc.nextInt();
            arr[i][1] = i;
        }

        Arrays.sort(arr,(o1,o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();

        int m = 0;

        while(k -- > 0 && arr[0][0] < arr[n-1][0] - 1){
            res.add(new int[]{arr[n-1][1] + 1,arr[0][1] + 1});
            arr[0][0] ++;
            arr[n-1][0] --;
            Arrays.sort(arr,(o1,o2) -> o1[0] - o2[0]);
            m++;
        }


        System.out.println((arr[n-1][0] - arr[0][0]) + " " + m);

        for (int[] x : res){
            System.out.println(x[0] + " " + x[1]);
        }


    }
    
    public static void main(String[] args) {
        Main m = new Main();
        // int t = sc.nextInt();
        int t = 1;
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