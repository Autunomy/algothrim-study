//2496. 数组中字符串的最大值
class Solution {
    public int maximumValue(String[] strs) {
        int maxNum = -1;
        for(int i=0;i<strs.length;++i){
            String s = strs[i];
            boolean flag = true;
            int temp = 0;
            for(int j=0;j<s.length();++j){
                if(s.charAt(j) < '0' || s.charAt(j) > '9'){
                    flag = false;
                    break;
                }
                temp *= 10;
                temp += (s.charAt(j)-'0');
            }
            if(flag){
                if(maxNum < temp) maxNum = temp;
            }else{
                if(maxNum < s.length()) maxNum = s.length();
            }
        }
        return maxNum;
    }
}