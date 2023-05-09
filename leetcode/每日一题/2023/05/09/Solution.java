/*
题目：2437. 有效时间的数目
原题链接：https://leetcode.cn/problems/number-of-valid-clock-times/description/
*/
class Solution {
    public int countTime(String time) {
        int res = 1;
        if(time.charAt(0) == '?'){
            if(time.charAt(1) == '?') res *= 3;
            else if(time.charAt(1)-'0' >= 4) res *= 2;
            else res *= 3;
        }
        if(time.charAt(1) == '?'){
            if(time.charAt(0)-'0' < 2) res*=10;
            else if(time.charAt(0) == '?') res*=8;
            else res *= 4;
        }
        if(time.charAt(3) == '?'){
            res *= 6;
        }
        if(time.charAt(4) == '?'){
            if(time.charAt(3)-'0' < 6 || time.charAt(3) == '?'){
                res *= 10;
            }else{
                res += 1;
            }
        }
        return res;
    }
}