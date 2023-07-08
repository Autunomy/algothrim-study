//167. 两数之和 II - 输入有序数组
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0,r = n-1;
        int[] res = null;;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                res =  new int[]{l+1,r+1};
                break;
            }else if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}