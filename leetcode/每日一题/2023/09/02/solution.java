//2511.最多可以摧毁的敌人城堡数目
class Solution {
    public int captureForts(int[] forts) {
        int i=0,j=1;
        int res = 0;
        while(j < forts.length){
            if(forts[i] == 1){
                while(j < forts.length && forts[j] == 0) j++;
                if(j < forts.length) {
                    if(forts[j] != 1){
                        res = Math.max(res,j-i-1);   
                    }
                    i=j;
                    j++;
                }
            }else{
                i++;
                j++;
            }
        }
        i=forts.length-1;
        j=i-1;
        while(j >= 0){
            if(forts[i] == 1){
                while(j >= 0 && forts[j] == 0) j--;
                if(j >= 0) {
                    if(forts[j] != 1){
                        res = Math.max(res,i-j-1);   
                    }
                    i=j;
                    j--;
                }
            }else{
                i--;
                j--;
            }
        }
        return res;
    }
}