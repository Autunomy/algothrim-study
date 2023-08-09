class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n > 0){
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return mul - sum;
    }
}