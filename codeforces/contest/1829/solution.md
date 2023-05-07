# A

题意：求与codeforces不同的字母个数，输入的字符串长度固定为10

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

    void solve(){
        String s = sc.next();
        String tem = "codeforces";
        int cnt = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) != tem.charAt(i)) cnt++;
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

# B

题意：求连续0的最长长度

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

    void solve(){
        int n = sc.nextInt();
        int[] a = scIntArr(n);
        
        int cnt = 0;
        int res = 0;
        for(int i=0;i<n;++i){
            if(a[i] == 0) cnt++;
            else{
                res = Math.max(res,cnt);
                cnt = 0;
            }
        }
        res = Math.max(res,cnt);
        System.out.println(res);
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

# C

题意：能够成11这个二进制串的最小花费，输入中前一个值为花费，另一个是可以获取的二进制串

思路：找到10对应的最小花费min10，01的最小花费min01，11的最小花费min11，他们的初始值为int的最大值`Integer.MAX_VALUE`

最终会有以下四种情况

- `(min10 == Integer.MAX_VALUE || min01 == Integer.MAX_VALUE) && min11 == Integer.MAX_VALUE` 说明无法构成一个11
- `min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE` 那么答案只能是min11
- `min11 == Integer.MAX_VALUE` 那么答案只能是`min01 + min10`
- 取两个最小

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

    void solve(){
        int n = sc.nextInt();
        int min01 = Integer.MAX_VALUE,min10 = Integer.MAX_VALUE,min11 = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            int a = sc.nextInt();
            String s = sc.next();
            if(s.equals("10")) min10 = Math.min(a,min10);
            if(s.equals("01")) min01 = Math.min(a,min01);
            if(s.equals("11")) min11 = Math.min(a,min11);
        }
        if((min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE) && min11 == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }else if(min01 == Integer.MAX_VALUE || min10 == Integer.MAX_VALUE){
            System.out.println(min11);
        }else if(min11 == Integer.MAX_VALUE){
            System.out.println(min01 + min10);
        }else{
            System.out.println(Math.min(min01 + min10 , min11));    
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

# D

题意：

可以进行的操作：将n分为两堆，其中一堆是另一堆的一倍

判断是否可以在若干次操作内分出来m

思路：

模拟以下分的过程，但是要注意使用set去重，防止超时

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
    void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if(n == m) {
            System.out.println("YES");
            return;
        }
        if(n < m || n < 3 || n % 3 != 0) {
            System.out.println("NO");
            return;
        }
        Set<Integer> s = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        
        q.addLast(n);
        while(q.size() > 0){
            int len = q.size();
            while(len -- > 0){
                int x = q.poll();
                if(!s.contains(x)){
                    s.add(x);
                    if(x == m){
                        System.out.println("YES");
                        return;
                    }
                    
                    if(x % 3 == 0){
                        if(x / 3 >= m){
                            q.addLast(x/3);
                        }
                        if(2*x/3 >= m){
                            q.addLast(2*x/3);
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

# E

题意：类似于力扣的岛屿面积，所有不为0的地方为湖，求湖的面积最大的湖。面积是湖对应的所有格子的数字之和

思路：dfs或bfs搜一下即可

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
    boolean[][] st;
    int[][] arr;
    int n,m;
    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};
    void solve(){
         n = sc.nextInt();
         m = sc.nextInt();
        
        arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j] = sc.nextInt();
            }
        }
        
        st = new boolean[n][m];
        
        int res = 0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(!st[i][j]){
                    res = Math.max(res,dfs(i,j));
                }
            }
        }
        System.out.println(res);
    }
    
    int dfs(int x,int y){
        if(x < 0 || x >= n || y < 0 || y >= m || arr[x][y] == 0 || st[x][y]) return 0;
        int res = arr[x][y];
        st[x][y] = true;
        for(int i=0;i<4;++i){
            res += dfs(x+dx[i],y+dy[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

# F

题意：一个中心节点称为一级节点，上面连接x个节点称为二级节点，每个二级节点连接y个三级节点。给出一个图，求对应的x和y

思路：

图的节点数很小，可以使用邻接矩阵保存。

这个图中节点的边的数量的种数一定<=3，那么就可以统计一下每个节点的边的数量并排序，设最大值为a，大于1的最小值为b

三级节点的数量 = 所有边数为1的点的数量

由于x*y == 三级节点的数量，所以判断一下

- (a-1) * b == 三级节点的数量  那么 x = b,y = a-1
- a * (b-1) == 三级节点的数量  那么 x = a,y = b-1

这样判断的理由就是二级节点的边数-1是y，所以如果出现了-1，则一定是y

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

    void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] g = new int[n][n];
        Map<Integer,Integer> bian = new HashMap<>();
        for(int i=0;i<m;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a-1][b-1] = 1;
            g[b-1][a-1] = 1;
            bian.put(a-1,b-1);
            bian.put(b-1,a-1);
        }
        int[] arr = new int[n];
        int max1 = -1,max2 = -1;
        for(int i=0;i<n;++i){
            int cnt = 0;
            for(int j=0;j<n;++j){
                if(g[i][j] == 1){
                    cnt++;
                }
            }
            arr[i] = cnt;
        }
        int mul = 0;
        for(int i=0;i<n;++i){
            if(arr[i] == 1) mul ++;
        }
        Arrays.sort(arr);
        int a = 0,b = arr[n-1];
        for(int i=0;i<n;++i){
            if(arr[i] > 1) {
                a = arr[i];
                break;
            }
        }
        
        if((a-1) * b == mul){
            System.out.println(b + " " + (a-1));
        }else{
            System.out.println(a + " " + (b-1));
        }
    }
    


    public static void main(String[] args) {
        Main m = new Main();
        int t = sc.nextInt();
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

