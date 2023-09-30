# java模板

```java
import java.util.Scanner;

public class Main {
    final static int N = 100010;
    //存储trie的数组,数组中的元素存储的是当前字符串对应的cnt的下标，也就是当前字符串的出现次数对应的下标
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];//存储每个字符串出现的次数
    static int idx = 0;//cnt的下标，表示当前字符串出现次数对应的下标
    
    //将字符串插入字典树
    public static void insert(String str){
        int p = 0;
        for(int i=0;i<str.length();++i){
            char c = str.charAt(i);
            //若子节点不存在就创建
            if(son[p][c-'a'] == 0) son[p][c-'a'] = ++idx;
            p = son[p][c-'a'];
        }
        cnt[p] ++;//将字符串出现次数+1
    }

    public static int query(String str){
        int p = 0;
        for(int i=0;i<str.length();++i){
            char c = str.charAt(i);
            if(son[p][c-'a'] == 0) return 0;
            p = son[p][c-'a'];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;++i){
            String[] ops = sc.nextLine().split(" ");
            if("I".equals(ops[0])){
                insert(ops[1]);
            }else{
                System.out.println(query(ops[1]));
            }
        }
    }
}
```

# Cpp模板

```cpp
#include<iostream>
#include<cstring>
using namespace std;

const int N = 1000010;
int trie[N][26],cnt[N],idx;
int n,m;

void insert(char s[]){
    int p = 0;
    for(int i=0;s[i];++i){
        int u = s[i]-'a';
        if(!trie[p][u]) trie[p][u] = ++idx;
        p = trie[p][u];
    }
    cnt[p]++;
}

int query(char s[]){
    int p = 0,res = 0;
    
    for(int i=0;s[i];++i){
        int u = s[i] - 'a';
        if(trie[p][u] == 0) return res;
        p = trie[p][u];
        res += cnt[p];
        //注意这里的cnt应该是以这个字母结尾的单词的个数 所以应该先向后走一下 
        //要不然第一次执行时cnt[p]并不表示任何单词个数 那么最后的循环就会少统计一个前缀的数量
        
    }
    return res;
}

int main(){
    scanf("%d%d",&n,&m);
    for(int i=0;i<n;++i){
        char s[N];
        scanf("%s",s);
        insert(s);
    }
    for(int i=0;i<m;++i){
        char s[N];
        scanf("%s",s);
        printf("%d\n",query(s));
    }
    return 0;
}
```

# 练习题

| 题目                                                         | 难度 | 题解                                                 |
| ------------------------------------------------------------ | ---- | ---------------------------------------------------- |
| [前缀统计](https://www.acwing.com/problem/content/144/)      | 简单 | [题解](http://www.autunomy.top/solution/content/127) |
| [最大异或对](https://www.acwing.com/problem/content/145/)    | 简单 | [题解](http://www.autunomy.top/solution/content/126) |
| [删除子文件夹](https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/description/) | 中等 | [题解](http://www.autunomy.top/solution/content/160) |
| [字符流](https://leetcode.cn/problems/stream-of-characters/description/) | 困难 | [题解](http://www.autunomy.top/solution/content/188) |