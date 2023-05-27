思路：DFS+记忆化搜索

```java
class Solution {
    int res = Integer.MAX_VALUE;
    int[] rec;//记忆化
    public int minExtraChar(String s, String[] dictionary) {
        rec = new int[s.length()];
        Arrays.fill(rec,-1);
        res = dfs(0,s,dictionary,0);
        return res;
    }
    
    int dfs(int i,String s,String[] dictionary,int cnt){
        if(i == s.length()){
            return 0;
        }
        
        if(rec[i] != -1) return rec[i];
        
        int re = Integer.MAX_VALUE;
        boolean flag = false;//标志是否至少和dic中的一个字符串相同
        for(int j=0;j<dictionary.length;++j){
            String d = dictionary[j];
            int temp1 = i;
            int temp2 = 0;
            //判断当前子串与dic中的字符串是否相同
            while(temp1 < s.length() && temp2 < d.length() && s.charAt(temp1) == d.charAt(temp2)){
                temp1 ++;
                temp2 ++;
            }

            if(temp2 == d.length()) {
                flag = true;
                //dfs
                re = Math.min(dfs(temp1,s,dictionary,cnt),re);
            }
        }
        //如果以当前字符开头的子串不能匹配任何一个dic中的字符串
        if(!flag) re = dfs(i + 1,s,dictionary,cnt+1) + 1;
        else re = Math.min(dfs(i + 1,s,dictionary,cnt+1) + 1,re);
        rec[i] = re;//记忆化
        return re;
    }
}
```