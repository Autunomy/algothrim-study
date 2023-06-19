//1262. 可被三整除的最大和
class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> one = new ArrayList<>(); // 存放 mod3=1 的数
        List<Integer> two = new ArrayList<>(); // 存放 mod3=2 的数
        
        int sum = 0;
        for (int e : nums) {
            if (e % 3 == 1) one.add(e);
            if (e % 3 == 2) two.add(e);
            sum += e;
        }

        Collections.sort(one);
        Collections.sort(two);
        
        int res = sum % 3, ans = 0;
        
        if (res == 0) return sum;
        
        if (res == 1) {
            //剔除一个满足mod3==1的数， 或两个满足mod3==2的数
            if (two.size() >= 2) ans = Math.max(ans, sum-two.get(0)-two.get(1));
            if (one.size() >= 1) ans = Math.max(ans, sum-one.get(0));    
        } else if (res == 2) {
            //剔除一个满足mod3==2的数， 或两个满足mod3==1的数
            if (two.size() > 0) ans = Math.max(ans, sum-two.get(0));
            if (one.size() >= 2) ans = Math.max(ans, sum-one.get(0)-one.get(1)); 
        }
        return ans;
             
    }
}