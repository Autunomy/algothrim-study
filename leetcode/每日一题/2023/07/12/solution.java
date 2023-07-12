//2544. 交替数字和
class Solution {
    public int alternateDigitSum(int n) {
        int res = 0;
        String s = n + "";
        int mul = 1;
        for(int i=0;i<s.length();++i){
            res += Integer.valueOf(s.charAt(i) + "") * mul;
            mul = - mul;
        }
        return res;
    }
}