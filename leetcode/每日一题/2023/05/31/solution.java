/*
思路：
为了让最后的和最小，应该尽量让大的节点靠上，小的节点靠下
类似于huffman树的构建，但是不能打乱原有的顺序。所以需要使用单调栈来保存当前节点相邻的左右两边的最小值节点
具体可看：https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/solutions/377595/wei-shi-yao-dan-diao-di-jian-zhan-de-suan-fa-ke-xi/
*/

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        int n = arr.length;
        int[] stack = new int[n + 10];
        int top = -1;
        stack[++top] = Integer.MAX_VALUE;

        for(int i=0;i<n;++i){
            while(arr[i] >= stack[top]){
                int temp = stack[top--];
                res += temp * Math.min(arr[i],stack[top]);
            }

            stack[++top] = arr[i];
        }

        while(top > 1){
            int temp = stack[top--];
            res += stack[top] * temp;
        }

        return res;
    }
}