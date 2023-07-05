//2600. K 件物品的最大和
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes >= k) return k;
        if(numOnes + numZeros >= k) return numOnes;
        return numOnes - (k-numOnes-numZeros);
    }
}