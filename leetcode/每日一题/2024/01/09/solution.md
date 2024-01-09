2707. 字符串中的额外字符

```java
class Solution {
    int res = Integer.MAX_VALUE;
    int[] rec;
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
        boolean flag = false;
        for(int j=0;j<dictionary.length;++j){
            String d = dictionary[j];
            int temp1 = i;
            int temp2 = 0;
            while(temp1 < s.length() && temp2 < d.length() && s.charAt(temp1) == d.charAt(temp2)){
                temp1 ++;
                temp2 ++;
            }

            if(temp2 == d.length()) {
                flag = true;
                re = Math.min(dfs(temp1,s,dictionary,cnt),re);
            }
        }
        if(!flag) re = dfs(i + 1,s,dictionary,cnt+1) + 1;
        else re = Math.min(dfs(i + 1,s,dictionary,cnt+1) + 1,re);
        rec[i] = re;
        return re;
    }
}
```