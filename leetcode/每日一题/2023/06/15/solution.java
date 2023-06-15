//1177. 构建回文串检测
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n=s.length(),mask[]=new int[n+1];
        for(int i=1;i<=n;i++){
            mask[i]=mask[i-1]^(1<<(s.charAt(i-1)-'a'));
        }
        List<Boolean> ans=new ArrayList<>();
        for(int q[]:queries){
            ans.add(Integer.bitCount(mask[q[1]+1]^mask[q[0]])/2<=q[2]);
        }
        return ans;
    }
}