//LCP 50. 宝石补给
class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for(int i=0;i<operations.length;++i){
            int x = operations[i][0];
            int y = operations[i][1];

            int temp = gem[x] / 2;
            gem[x] -= temp;
            gem[y] += temp;
        }

        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}