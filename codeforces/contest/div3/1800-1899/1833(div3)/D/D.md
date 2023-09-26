题意：
您将获得长度为n的排列p，排列是由 n个不同整数组成的数组，从 1到 n按任意顺序排列。例如， {2,3,1,5,4}是排列，而 {1,2,2}不是（因为 2出现了两次）， {1,3,4}也不是排列（如 n=3，但数组包含 4）
对于排列 p，您需要只应用一次以下操作：
- 首先，你选择一个段 [l,r]（ 1≤l≤r≤n，一个段是连续的数字序列 {pl,pl+1,…,pr−1,pr}） 并反转它。反转段意味着交换数字对 (pl,pr)， (pl+1,pr−1)， ...， (pl+i,pr−i)（其中 l+i≤r−i）。
- 然后交换前缀和后缀： [r+1,n]和 [1,l−1]（请注意，这些段可能为空）。

例如，给定 n=5,p={2,3,1,5,4}，如果选择段 [l=2,r=3]，在反转段 p={2,1,3,5,4}后，则交换段 [4,5]和 [1,1]。因此， p={5,4,1,3,2}.可以证明，这是给定排列的最大可能结果。

您需要输出字典顺序上的最大排列，该排列可以通过应用一次描述的操作来获得。

思路：

先找到最大值max1和次大值max2的下标
如果max1 == 0，则最大的排列一定是第二大的值在首部，让max1 = max2（为了方便，这里可以将 max1理解为需要放在首位的元素的下标）。
做完上一步后，判断如果max1 == n-1，在最后一位，则逆转的就是从n-1开始向前逆转，从n-2开始判断，如果a[i] < [0]则停止逆转，需要逆转的区间就是[i+1,n-2]
如果max1 != n-1，则在最前面的排列一定是[max1,n-1],然后需要逆转的部分是从max1-1开始，如果a[i] < a[0]停止逆转，需要逆转的区间就是[i+1,max1-1]

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
        int[] arr = scIntArr(n);

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        int max1 = -1,max2 = -1;
        for(int i=0;i<n;++i){
            if(max1 == -1) {
                max1 = i;
                continue;
            }
            if(arr[i] > arr[max1]){
                max2 = max1;
                max1 = i;
            }else if(max2 == -1 || arr[i] > arr[max2]){
                max2 = i;
            }
        }


        if(max1 == 0) max1 = max2;

        if(max1 == n-1){
            int i;
            System.out.print(arr[max1] + " ");
            for(i=max1-1;i>=0 && arr[i] > arr[0];--i){
                System.out.print(arr[i] + " ");
            }
 
            for(int j=0;j<=i;++j) System.out.print(arr[j] + " ");
        }else{
            for(int i=max1;i<n;++i) System.out.print(arr[i] + " ");
            System.out.print(arr[max1-1] + " ");
            int j;
            for(j=max1 - 2;j>=0 && arr[j] > arr[0];--j){
                System.out.print(arr[j] + " ");
            }
            for(int i=0;i<=j;++i) System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        // int t = 1;
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