
算法标签: 构造题、1400

题意:
由于索尼娅也对机器人感兴趣，她决定建造能够读取和识别数字的机器人。
索尼娅连续绘制了 个 n个数字， ai位于 i-th位置。她还在行的每一端放置了一个机器人（第一个数字的左侧和最后一个数字的右侧）。索尼娅会给每个机器人一个数字（它们可以相同或不同）并运行它们。当一个机器人运行时，它会向另一个机器人移动，读取行中的数字。当机器人读取的数字等于提供给该机器人的数字时，它将关闭并保持在同一位置。
索尼娅不希望机器人坏掉，所以她会给出这样的数字，让机器人在见面之前停下来。也就是说，女孩希望他们停在不同的位置，以便第一个机器人在第二个机器人的左侧。
例如:如果写入数字 [1,5,4,1,3]，如果给第一个机器人选择4,第二个机器人选择5则会相遇，如果第一个机器人选择5，第二个机器人选择4则不会相遇
索尼娅明白，给出一个没有写在行中的数字是没有意义的，因为机器人找不到这个数字并且会遇到另一个机器人。
索尼娅想知道有多少个对不同且可以被选择（只要对应位置数字不同则视为不同的对，例如[1,2]和[2,1]是两个不同的对）

思路:
先用一个map统计所有的数字出现的次数，再从前向后遍历数组每次遍历的值就是第一个机器人选择的值，处理当前数字前先将map中的出现次数-1，如果变为0就移除map，此时当前数字能形成的对数就是map的size()也同时是第二个机器人能选择的数字，处理完当前数字后加入set中，表示当前数字不能再被第一个机器人选择


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

        Map<Integer,Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }

        long res = 0L;

        for(int i=0;i<n;++i){
            map.put(arr[i],map.get(arr[i])-1);
            if(map.get(arr[i]) == 0) map.remove(arr[i]);
            if(!set.contains(arr[i])){
                int num = map.size();
                res += (long)num;
                set.add(arr[i]);
            }
        }
        System.out.println(res);
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