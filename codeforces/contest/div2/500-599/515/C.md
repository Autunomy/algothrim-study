算法标签:贪心、数学、排序、1400

题意:
给出一个n位十进制数a,其中至少有一位比1大，且可能有前导0
定义F(a)是a的每一位的阶乘的成绩  -> `F(123) = 1!*2!*3!`
求出最大的x满足F(x) = F(a) 其中x不含0也不含1


思路:
一共只有8种数字需要处理[2,9]，我们只要能求出每一个数字可以分解的情况即可
```
2! -> 2!
3! -> 3!
4! -> 3! * 2! * 2!
5! -> 5!
6! -> 5! * 3!
7! -> 7!
8! -> 7! * 2! * 2! * 2!
9! -> 7! * 2! * 3! * 3!
```
将原来的数字的大于1的每一位都进行替换，然后将大的值放前，小的值放后，即可得到最后的答案

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
    
    int[] mul;
    int[][] st;
    String res = "";
    void solve(){
        int n = sc.nextInt();
        String str = sc.next();
        
        Map<Integer,String> map = new HashMap<>();
        //将特殊值进行存储
        map.put(4,"322");
        map.put(6,"53");
        map.put(8,"7222");
        map.put(9,"7233");
        
        //存储答案中包含的所有数字
        String preRes = "";
        for(int i=0;i<str.length();++i){
            int num = str.charAt(i)-'0';
            if(num > 1){
                if(map.get(num) != null){
                    preRes += map.get(num);
                }else{
                    preRes += num+"";
                }
            }
        }
        
        //转换为数组 方便排序
        int[] res = new int[preRes.length()];
        for(int i=0;i<preRes.length();++i){
            res[i] = preRes.charAt(i)-'0';
        }
        
        //排序
        Arrays.sort(res);
        //倒序输出
        for(int i=res.length-1;i>=0;--i){
            System.out.print(res[i]);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
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