题意：有一个游戏，给出两个长度相同的字符串，每个字符代表一个卡牌，其中包含小写字母和@。每一个@可以被替换为"atcoder"中的一个字符，如果两个字符串最后相等(卡牌种类和数量完全相同)，则输出Yes，否则输出No。
但是可以进行作弊操作：如果当前不是第一次出牌，那么就可以将其中一行按照任意顺序排序，判断是否能赢

思路：
首先判断s.length() == 1的情况 假设a是s.charAt(0),b是t.charAt(0)
1. a == b 直接输出yes
2. a == '@' && b在"atcoder"中 输出yes
3. a 在"atcoder"中&& b == '@' 输出yes
4. a == '@' && b == '@' 输出yes
5. 剩余情况输出no

s.length() > 1
统计所有的字符出现的次数并进行遍历，然后判断是否能用@补齐


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
        String s = sc.next();
        String t = sc.next();

        if(s.length() == 1){
            char a = s.charAt(0);
            char b = t.charAt(0);
            if(a == b){
                System.out.println("Yes");
            }else if(a == '@' && "atcoder".indexOf(b) != -1){
                System.out.println("Yes");
            }else if("atcoder".indexOf(a) != -1 && b == '@'){
                System.out.println("Yes");
            }else if(a == '@' && b == '@'){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

            return;
        }

        //第26位统计的是@出现的次数
        int[] cnt1 = new int[27];
        int[] cnt2 = new int[27];

        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == '@') cnt1[26]++;
            else cnt1[s.charAt(i)-'a'] ++;

            if(t.charAt(i) == '@') cnt2[26]++;
            else cnt2[t.charAt(i)-'a'] ++;
        }
        
        boolean flag = true;
        for(int i=0;i<27;++i){
            if(cnt1[i] != cnt2[i]) {
                //如果当前字符是"atcoder"其中一个 可以用@替换
                if("atcoder".indexOf((char)(i+'a')) != -1){
                    //s中该字符次数比t中多且t中的@数量足够
                    if(cnt1[i] > cnt2[i] && cnt2[26] + cnt2[i] >= cnt1[i]){
                        cnt2[26] -= (cnt1[i] - cnt2[i]);
                    }else if(cnt1[i] < cnt2[i] && cnt1[26] + cnt1[i] >= cnt2[i]){//t中该字符次数比s中多且s中的@数量足够
                        cnt1[26] -= (cnt2[i] - cnt1[i]);
                    }else{
                        flag = false;
                        break;
                    }
                }else{//如果当前字符不是"atcoder"其中一个 不能用@替换
                    flag = false;
                    break;
                }
            }
        }

        if(flag) System.out.println("Yes");
        else System.out.println("No");

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