/*
题目：1016. 子串能表示从 1 到 N 数字的二进制串
原题链接：https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/description/

思路:
给的数据范围中n是1e9，二进制表示为0011 1011 1001 1010 1100 1010 0000 0000,去掉前导0后，长度
为30bit，所以在s中最多只需要判断长度为30的字符串即可
枚举s的所有长度小于等于30的子字符串，并将其能表示的十进制放在一个hash表中。
如果最后hash的大小小于n,则不能表示从[1,n]
如果最后hash的大小大于等于n从1到n开始枚举，判断值是否存在于hash表中
*/
class Solution {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();

        //找出所有能表示的十进制数
        for(int i=0;i<s.length();++i){
            int cnt = 0;
            for(int j=i;j<i+30&&j<s.length();++j){
                cnt <<= 1;
                cnt += s.charAt(j)-'0'; 
                set.add(cnt);
                              
            }
        }
        //hash的大小小于n
        if(n > set.size()) return false;
        //从1开始枚举
        for(int i=1;i<=n;++i){
            if(!set.contains(i)) return false;
        }

        return true;
    }
}