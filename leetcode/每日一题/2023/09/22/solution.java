//2591. 将钱分给最多的儿童
class Solution {
    public int distMoney(int money, int children) {
        if(money < children) return -1;
        if(money < children + 7) return 0;
        
        int res = 0;
        money -= children;
        for(int i=0;i<children;++i){
            if(money >= 7){
                res ++;
                money -= 7;
            }else{
                if(money == 3 && i == children - 1){
                    res = Math.max(0,res - 1);
                }
                money = 0;
                break;
            }
        }
        if(money > 0) res --;
        return res;
    }
}