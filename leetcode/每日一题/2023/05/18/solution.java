/*
    思路：先把两个数组加起来合并到一个新数组nums中，从后向前遍历nums
        1. nums[i] == 0 || nums[i] == 1 不操作
        2. nums[i] == 2 如果nums[i-1] >= 1则可以给nums[i-1]-1，然后nums[i] = 0; 反之给nums[i-1] ++;nums[i-2] ++;nums[i]=0;
        3. nums[i] == 3 如果nums[i-1] >= 1则可以给nums[i-1]-1，然后nums[i] = 1; 反之给nums[i-1] ++;nums[i-2] ++;nums[i]=1;
        4. nums[i] == 4 同理进行判断即可
    例如  arr1 = [1,1,1,1,1] arr2 = [1,0,1] 相加 nums = [1,1,2,1,2]  其中的第1位是 2 * (-2)^0 可以用第二位的(-2)^1抵消掉，
    同理第3位的2也可以使用第4位的1抵消掉，所以结果就是[1,0,0,0,0]
*/
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] nums = new int[2010];

        int i = arr1.length-1;
        int j = arr2.length-1;
        int cnt = 2009;
        while(i >= 0 && j >= 0){
            nums[cnt] = arr1[i] + arr2[j];
            i--;
            j--;
            cnt--;
        }

        while(i >= 0) nums[cnt--] = arr1[i--];
        while(j >= 0) nums[cnt--] = arr2[j--];

        i = 2009;
        while(i >= 2){
            while(nums[i] >= 2){
                if(nums[i-1] >= 1){
                    nums[i] -= 2;
                    nums[i-1] --;
                }else{
                    nums[i] -= 2;
                    nums[i-1] ++;
                    nums[i-2] ++;
                }
            }
            i--;
        }

        for(i=0;i<2010;++i){
            if(nums[i] != 0) break;
        }

        if(i == 2010){
            return new int[]{0};
        }

        int[] res = new int[2010-i];
        cnt = 0;
        for(;i<2010;++i) res[cnt++] = nums[i];


        return res;
    }
}