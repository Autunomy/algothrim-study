//822.翻转卡片游戏
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int res = Integer.MAX_VALUE;
        int n = fronts.length;
        for(int i=0;i<n;++i){
            boolean flagf = true;
            boolean flagb = true;
            for(int j=0;j<n;++j){
                if(fronts[i] == fronts[j] && fronts[i] == backs[j]){
                    flagf = false;
                }
                if(backs[i] == fronts[j] && backs[i] == backs[j]){
                    flagb = false;
                }
            }

            if(flagf) res = Math.min(res,fronts[i]);
            if(flagb) res = Math.min(res,backs[i]);
        }
        if(res == Integer.MAX_VALUE) res = 0;

        return res;
    }
}