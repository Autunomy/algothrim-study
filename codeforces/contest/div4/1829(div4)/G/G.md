# G

题意：一个金子塔有2023层，我们去掉n对应的积木，那么与n上边连接的所有积木都会倒塌，求倒塌部分的积木的值之和。每个积木有编号为i,其价值为i*i

题解：

每一层倒塌的积木一定是连续的

1. 求出来n这一层的行数row (row自顶向下从1开始) 每一层的积木数量==层数
2. 设置每一层倒塌积木的左边为left,右边为right,初始值都为n。设start为每一层最左边的编号，end为每一层最右边的编号
3. 求出当前层的价值之后，更新倒塌积木的左右边界：
    1. 如果left == start  那么 left = left - row + 1; 如果left != start 那么left = left - row;
    2. 如果right == end 那么 right = right - row; 如果right != end 那么 right = right - row + 1;

注意：由于每次都要求[left,right]区间的和，那么我们可以预处理一个前缀和数组preSum[i] = preSum[i-1] + i*i; 计算[left,right]区间的价值直接利用`preSum[right] - preSum[left-1]`即可得到

```java
import java.io.*;
import java.util.*;

/**
 * @author hty
 * @date 2023-04-28 18:24
 * @email 1156388927@qq.com
 * @description
 * @other 题解及更多请看www.autunomy.top
 */

public class Main {
    private static Kattio sc = new Kattio();
    static long[] preSum = new long[3000010];
    void solve(){
        int n = sc.nextInt();
        int row = 1;
        int sum = 0;
        while(sum + row < n){
            sum += row;
            row++;
        }
        int idx = n-sum;
        int start = sum+1;
        int end = sum+row;
        int left = n;
        int right = n;
        long res = 0L;
        // System.out.println(preSum[n]);
        while(sum > 0){
            
            res += (long)preSum[right] - preSum[left-1];
            
            if(left == start){
                left -= (row-1);
            }else{
                left -= row;
            }
            if(right == end)
                right -= row;
            else right = right - row + 1;
            
            
            row--;
            sum -= row;
            start = sum+1;
            end = sum+row;
        }
        
        System.out.println(res+1);
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
        
        for(int i=1;i<3000010;++i){
            preSum[i] = (long)i*i + preSum[i-1];
        }
        
        while (t-- > 0) {
            m.solve();
        }
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

