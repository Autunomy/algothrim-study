//771.宝石与石头
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();   
        int res = 0;

        for(int i=0;i<jewels.length();++i) set.add(jewels.charAt(i));
        for(int i=0;i<stones.length();++i){
            if(set.contains(stones.charAt(i))) res ++;
        }

        return res;
    }
}